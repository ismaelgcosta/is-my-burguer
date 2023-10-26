package br.com.ismyburguer.pedido.adapters.web.converter;

import br.com.ismyburguer.pedido.adapters.web.request.AlterarPedidoRequest;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import jakarta.validation.ConstraintViolationException;

import java.util.UUID;

@WebConverter
public class AlterarPedidoRequestConverter implements Converter<AlterarPedidoRequest, Pedido> {

    private final AlterarItemPedidoRequestConverter itemPedidoRequestConverter;

    public AlterarPedidoRequestConverter(AlterarItemPedidoRequestConverter itemPedidoRequestConverter) {
        this.itemPedidoRequestConverter = itemPedidoRequestConverter;
    }

    public Pedido convert(AlterarPedidoRequest source) {
        if (source == null) {
            throw new ConstraintViolationException("Não foi informado o corpo da requisição", null);
        }

        if (source != null) {
            source.validate();
        }

        return new Pedido(
                source.getClienteId().map(UUID::fromString).map(Pedido.ClienteId::new).orElse(null),
                null,
                source.getItens()
                        .stream()
                        .map(itemPedidoRequestConverter::convert)
                        .toList()
        );
    }
}
