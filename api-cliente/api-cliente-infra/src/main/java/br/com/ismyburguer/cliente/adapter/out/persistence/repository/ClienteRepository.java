package br.com.ismyburguer.cliente.adapter.out.persistence.repository;

import br.com.ismyburguer.cliente.adapter.out.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
    Optional<ClienteEntity> findByClienteId(UUID clienteId);
    Optional<ClienteEntity> findByEmailIgnoreCase(String email);
}
