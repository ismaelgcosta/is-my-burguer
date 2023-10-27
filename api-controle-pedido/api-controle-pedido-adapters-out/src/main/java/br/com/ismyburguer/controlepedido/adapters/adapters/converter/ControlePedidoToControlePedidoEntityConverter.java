package br.com.ismyburguer.controlepedido.adapters.adapters.converter;

import br.com.ismyburguer.controlepedido.adapters.adapters.entity.StatusControlePedidoEntity;
import br.com.ismyburguer.controlepedido.adapters.adapters.entity.ControlePedidoEntity;
import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class ControlePedidoToControlePedidoEntityConverter implements Converter<ControlePedido, ControlePedidoEntity> {
    @Override
    public ControlePedidoEntity convert(ControlePedido source) {
        return new ControlePedidoEntity(
                source.getPedidoId().getPedidoId(),
                StatusControlePedidoEntity.valueOf(source.getStatusControlePedido().name()),
                source.getRecebidoEm()
        );
    }
}
