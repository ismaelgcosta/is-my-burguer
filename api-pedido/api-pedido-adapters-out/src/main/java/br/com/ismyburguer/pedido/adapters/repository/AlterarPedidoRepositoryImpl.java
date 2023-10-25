package br.com.ismyburguer.pedido.adapters.repository;

import br.com.ismyburguer.pedido.adapters.converter.PedidoToPedidoEntityConverter;
import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.out.AlterarPedidoRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class AlterarPedidoRepositoryImpl implements AlterarPedidoRepository {
    private final PedidoRepository pedidoRepository;
    private final PedidoToPedidoEntityConverter converter;

    public AlterarPedidoRepositoryImpl(PedidoRepository pedidoRepository,
                                        PedidoToPedidoEntityConverter converter) {
        this.pedidoRepository = pedidoRepository;
        this.converter = converter;
    }

    public void alterarPedido(String pedidoId, @Valid Pedido pedido) {
        UUID uuid = UUID.fromString(pedidoId);
        if(!pedidoRepository.existsById(uuid)) {
            throw new EntityNotFoundException("Pedido não foi encontrado");
        }

        PedidoEntity pedidoEntity = converter.convert(pedido);
        pedidoEntity.setPedidoId(uuid);
        pedidoRepository.save(pedidoEntity);
    }
}
