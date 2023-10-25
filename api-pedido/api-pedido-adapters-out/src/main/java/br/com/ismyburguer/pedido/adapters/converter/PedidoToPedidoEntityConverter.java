package br.com.ismyburguer.pedido.adapters.converter;

import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.adapters.entity.StatusPedidoEntity;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class PedidoToPedidoEntityConverter implements Converter<Pedido, PedidoEntity> {

    private final ItemPedidoToItemPedidoEntityConverter itemPedidoEntityConverter;

    public PedidoToPedidoEntityConverter(ItemPedidoToItemPedidoEntityConverter itemPedidoEntityConverter) {
        this.itemPedidoEntityConverter = itemPedidoEntityConverter;
    }

    @Override
    public PedidoEntity convert(Pedido source) {
        PedidoEntity pedidoEntity = new PedidoEntity(
                source.getPedidoId().getPedidoId(),
                source.getClienteId().map(Pedido.ClienteId::getClienteId).orElse(null),
                StatusPedidoEntity.valueOf(source.getStatusPedido().name()),
                source.getTotal().getValor()
        );

        source.getItens()
                .stream()
                .map(itemPedidoEntityConverter::convert)
                .forEach(pedidoEntity::addItem);
        return pedidoEntity;
    }
}
