package br.com.ismyburguer.pedido.adapters.converter;

import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.domain.model.ItemPedido;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class PedidoEntityToPedidoConverter implements Converter<PedidoEntity, Pedido> {

    private final ItemPedidoEntityToItemPedidoConverter itemPedidoConverter;

    public PedidoEntityToPedidoConverter(ItemPedidoEntityToItemPedidoConverter itemPedidoConverter) {
        this.itemPedidoConverter = itemPedidoConverter;
    }

    @Override
    public Pedido convert(PedidoEntity source) {
        return new Pedido(
                new Pedido.PedidoId(source.getPedidoId()),
                new Pedido.ClienteId(source.getClienteId()),
                Pedido.StatusPedido.valueOf(source.getStatusPedido().name()),
                source.getItens().stream().map(itemPedidoConverter::convert).toList()
        );
    }
}
