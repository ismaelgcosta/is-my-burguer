package br.com.ismyburguer.cliente.adapter.in.web;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final MongoTemplate mongoTemplate;
    private final DataSource dataSource;
    private final EntityManager entityManager;
    private final SessionFactory sessionFactory;

    public ClienteController(MongoTemplate mongoTemplate, DataSource dataSource, EntityManager entityManager, SessionFactory sessionFactory) {
        this.mongoTemplate = mongoTemplate;
        this.dataSource = dataSource;
        this.entityManager = entityManager;
        this.sessionFactory = sessionFactory;
    }

    @GetMapping
    @Transactional
    public String teste() {
        String retorno = "Nada bem";
        entityManager.createNativeQuery("select * from teste").getResultList();
        retorno = "Postgres tá ok\n";
        mongoTemplate.getCollection("testeCollection").countDocuments();
        retorno += "MongoDb tá ok";
        return retorno;
    }

}
