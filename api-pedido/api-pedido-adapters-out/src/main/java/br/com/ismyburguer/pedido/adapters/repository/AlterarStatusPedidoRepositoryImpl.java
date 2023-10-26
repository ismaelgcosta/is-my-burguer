package br.com.ismyburguer.pedido.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.pedido.adapters.converter.PedidoToPedidoEntityConverter;
import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.adapters.entity.StatusPedidoEntity;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.out.AlterarPedidoRepository;
import br.com.ismyburguer.pedido.ports.out.AlterarStatusPedidoRepository;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

@Validated
@PersistenceAdapter
public class AlterarStatusPedidoRepositoryImpl implements AlterarStatusPedidoRepository {
    private final PedidoRepository pedidoRepository;
    public AlterarStatusPedidoRepositoryImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void alterar(String pedidoId, Pedido.StatusPedido statusPedido) {
        UUID uuid = UUID.fromString(pedidoId);
        Optional<PedidoEntity> entity = pedidoRepository.findById(uuid);
        if(entity.isEmpty()) {
            throw new EntityNotFoundException("Pedido não foi encontrado");
        }
        PedidoEntity oldEntity = entity.get();
        oldEntity.setStatusPedido(StatusPedidoEntity.valueOf(statusPedido.name()));
        pedidoRepository.save(oldEntity);
    }
}
