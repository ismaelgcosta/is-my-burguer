package br.com.ismyburguer.pedido.adapters.web.converter;

import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import br.com.ismyburguer.pedido.adapters.web.request.AlterarItemPedidoRequest;
import br.com.ismyburguer.pedido.domain.model.ItemPedido;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import jakarta.validation.ConstraintViolationException;

import java.util.UUID;

@WebConverter
public class AlterarItemPedidoRequestConverter implements Converter<AlterarItemPedidoRequest, ItemPedido> {

    public AlterarItemPedidoRequestConverter() {
    }

    public ItemPedido convert(AlterarItemPedidoRequest source) {
        if(source == null) {
            throw new ConstraintViolationException("Não foi informado o corpo da requisição", null);
        }

        if(source != null) {
            source.validate();
        }

        return new ItemPedido(
                new ItemPedido.ProdutoId(UUID.fromString(source.getProdutoId())),
                new ItemPedido.Quantidade(source.getQuantidade()),
                new ItemPedido.Preco(source.getPreco())
        );
    }
}
