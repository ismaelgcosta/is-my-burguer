package br.com.ismyburguer.produto.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceDriver;
import br.com.ismyburguer.produto.adapters.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@PersistenceDriver
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
}
