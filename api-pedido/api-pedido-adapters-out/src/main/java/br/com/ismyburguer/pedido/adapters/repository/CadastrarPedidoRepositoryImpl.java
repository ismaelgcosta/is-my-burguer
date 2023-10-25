package br.com.ismyburguer.pedido.adapters.repository;

import br.com.ismyburguer.pedido.adapters.converter.PedidoToPedidoEntityConverter;
import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.out.CadastrarPedidoRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class CadastrarPedidoRepositoryImpl implements CadastrarPedidoRepository {
    private final PedidoRepository pedidoRepository;
    private final PedidoToPedidoEntityConverter converter;

    public CadastrarPedidoRepositoryImpl(PedidoRepository pedidoRepository,
                                          PedidoToPedidoEntityConverter converter) {
        this.pedidoRepository = pedidoRepository;
        this.converter = converter;
    }

    @Override
    public UUID salvarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = converter.convert(pedido);
        return pedidoRepository.save(pedidoEntity).getPedidoId();
    }
}
