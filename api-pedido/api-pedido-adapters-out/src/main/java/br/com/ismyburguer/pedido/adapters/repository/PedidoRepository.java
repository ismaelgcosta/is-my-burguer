package br.com.ismyburguer.pedido.adapters.repository;

import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.core.adapter.out.PersistenceDriver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@PersistenceDriver
public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {
}
