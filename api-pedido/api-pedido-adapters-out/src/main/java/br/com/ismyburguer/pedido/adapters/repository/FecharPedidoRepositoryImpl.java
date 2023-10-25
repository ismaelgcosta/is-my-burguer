package br.com.ismyburguer.pedido.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.pedido.adapters.converter.PedidoToPedidoEntityConverter;
import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.adapters.entity.StatusPedidoEntity;
import br.com.ismyburguer.pedido.ports.out.FecharPedidoRepository;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class FecharPedidoRepositoryImpl implements FecharPedidoRepository {
    private final PedidoRepository pedidoRepository;
    private final PedidoToPedidoEntityConverter converter;

    public FecharPedidoRepositoryImpl(PedidoRepository pedidoRepository,
                                      PedidoToPedidoEntityConverter converter) {
        this.pedidoRepository = pedidoRepository;
        this.converter = converter;
    }

    @Override
    public void fecharPedido(String pedidoId) {
        UUID uuid = UUID.fromString(pedidoId);
        PedidoEntity pedidoEntity = pedidoRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não foi encontrado"));

        pedidoEntity.setStatusPedido(StatusPedidoEntity.FECHADO);
        pedidoRepository.save(pedidoEntity);
    }
}
