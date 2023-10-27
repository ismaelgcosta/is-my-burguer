package br.com.ismyburguer.controlepedido.adapters.adapters.converter;

import br.com.ismyburguer.controlepedido.adapters.adapters.entity.ControlePedidoEntity;
import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class ControlePedidoEntityToControlePedidoConverter implements Converter<ControlePedidoEntity, ControlePedido> {
    @Override
    public ControlePedido convert(ControlePedidoEntity source) {
        return new ControlePedido(
                new ControlePedido.ControlePedidoId(source.getControlePedidoId()),
                new ControlePedido.PedidoId(source.getPedidoId()),
                ControlePedido.StatusControlePedido.valueOf(source.getStatusControlePedido().name()),
                source.getRecebidoEm(),
                source.getInicioDaPreparacao(),
                source.getFimDaPreparacao()
        );
    }
}
