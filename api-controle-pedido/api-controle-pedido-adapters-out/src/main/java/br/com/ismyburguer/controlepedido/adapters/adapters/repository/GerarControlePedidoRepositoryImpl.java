package br.com.ismyburguer.controlepedido.adapters.adapters.repository;

import br.com.ismyburguer.controlepedido.adapters.adapters.converter.ControlePedidoToControlePedidoEntityConverter;
import br.com.ismyburguer.controlepedido.adapters.adapters.entity.ControlePedidoEntity;
import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.out.out.GerarControlePedidoRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class GerarControlePedidoRepositoryImpl implements GerarControlePedidoRepository {
    private final ControlePedidoRepository controlepedidoRepository;
    private final ControlePedidoToControlePedidoEntityConverter converter;

    public GerarControlePedidoRepositoryImpl(ControlePedidoRepository controlepedidoRepository,
                                             ControlePedidoToControlePedidoEntityConverter converter) {
        this.controlepedidoRepository = controlepedidoRepository;
        this.converter = converter;
    }

    @Override
    public UUID gerar(ControlePedido controlePedido) {
        ControlePedidoEntity controlepedidoEntity = converter.convert(controlePedido);
        return controlepedidoRepository.save(controlepedidoEntity).getControlePedidoId();
    }
}
