package br.com.ismyburguer.pedido.adapters.converter;

import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;
import br.com.ismyburguer.pedido.adapters.entity.ItemPedidoEntity;
import br.com.ismyburguer.pedido.domain.model.ItemPedido;
import br.com.ismyburguer.pedido.domain.model.Pedido;

@PersistenceConverter
public class ItemPedidoEntityToItemPedidoConverter implements Converter<ItemPedidoEntity, ItemPedido> {
    @Override
    public ItemPedido convert(ItemPedidoEntity source) {
        return new ItemPedido(
                new ItemPedido.ItemPedidoId(source.getItemPedidoId()),
                new Pedido.PedidoId(source.getPedido().getPedidoId()),
                new ItemPedido.ProdutoId(source.getProdutoId()),
                new ItemPedido.Quantidade(source.getQuantidade()),
                new ItemPedido.Preco(source.getPreco())
        );
    }
}
