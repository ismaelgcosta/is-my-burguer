package br.com.ismyburguer.pedido.adapters.converter;

import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;
import br.com.ismyburguer.pedido.adapters.entity.ItemPedidoEntity;
import br.com.ismyburguer.pedido.domain.model.ItemPedido;

@PersistenceConverter
public class ItemPedidoToItemPedidoEntityConverter implements Converter<ItemPedido, ItemPedidoEntity> {
    @Override
    public ItemPedidoEntity convert(ItemPedido source) {
        return new ItemPedidoEntity(
                source.getItemPedidoId().map(ItemPedido.ItemPedidoId::getItemPedidoId).orElse(null),
                source.getProdutoId().getProdutoId(),
                source.getQuantidade().getValor(),
                source.getPreco().getValor(),
                source.getTotal().getValor()
        );
    }
}
