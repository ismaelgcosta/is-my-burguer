package br.com.ismyburguer.controlepedido.adapters.adapters.repository;

import br.com.ismyburguer.controlepedido.adapters.adapters.entity.ControlePedidoEntity;
import br.com.ismyburguer.controlepedido.adapters.adapters.entity.StatusControlePedidoEntity;
import br.com.ismyburguer.core.adapter.out.PersistenceDriver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@PersistenceDriver
public interface ControlePedidoRepository extends JpaRepository<ControlePedidoEntity, UUID> {

    Optional<ControlePedidoEntity> findByPedidoId(UUID pedidoId);
    List<ControlePedidoEntity> findAllByStatusControlePedidoNot(StatusControlePedidoEntity statusControlePedido);

}
