package br.com.ismyburguer.pedido.adapters.web.converter;

import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import br.com.ismyburguer.pedido.adapters.web.request.AlterarPedidoRequest;
import br.com.ismyburguer.pedido.adapters.web.response.BuscarItemPedidoResponse;
import br.com.ismyburguer.pedido.adapters.web.response.BuscarPedidoResponse;
import br.com.ismyburguer.pedido.domain.model.ItemPedido;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import jakarta.validation.ConstraintViolationException;

import java.util.UUID;

@WebConverter
public class BuscarItemPedidoConverter implements Converter<ItemPedido, BuscarItemPedidoResponse> {

    public BuscarItemPedidoResponse convert(ItemPedido source) {
        if (source == null) {
            throw new ConstraintViolationException("Não foi informado o corpo da requisição", null);
        }

        if (source != null) {
            source.validate();
        }

        return new BuscarItemPedidoResponse(
                source.getItemPedidoId().toString(),
                source.getProdutoId().toString(),
                source.getQuantidade().getValor(),
                source.getPreco().getValor(),
                source.getTotal().getValor()
        );
    }
}
