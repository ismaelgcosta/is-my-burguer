package br.com.ismyburguer.pedido.adapters.web.converter;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import br.com.ismyburguer.pedido.adapters.web.response.ListarControlePedidoResponse;
import jakarta.validation.ConstraintViolationException;

@WebConverter
public class ListarControlePedidoConverter implements Converter<ControlePedido, ListarControlePedidoResponse> {

    @Override
    public ListarControlePedidoResponse convert(ControlePedido source) {
        if (source == null) {
            throw new ConstraintViolationException("Não foi informado o corpo da requisição", null);
        }

        if (source != null) {
            source.validate();
        }

        return new ListarControlePedidoResponse(
                source.getPedidoId().getPedidoId().toString(),
                source.getStatusControlePedido().name()
        );
    }
}
