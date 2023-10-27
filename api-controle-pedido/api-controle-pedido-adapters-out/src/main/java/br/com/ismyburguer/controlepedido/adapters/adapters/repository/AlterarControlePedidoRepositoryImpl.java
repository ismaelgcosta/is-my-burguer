package br.com.ismyburguer.controlepedido.adapters.adapters.repository;

import br.com.ismyburguer.controlepedido.adapters.adapters.converter.ControlePedidoToControlePedidoEntityConverter;
import br.com.ismyburguer.controlepedido.adapters.adapters.entity.ControlePedidoEntity;
import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.out.out.AlterarControlePedidoRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import org.springframework.validation.annotation.Validated;

@Validated
@PersistenceAdapter
public class AlterarControlePedidoRepositoryImpl implements AlterarControlePedidoRepository {
    private final ControlePedidoRepository controlepedidoRepository;
    private final ControlePedidoToControlePedidoEntityConverter converter;

    public AlterarControlePedidoRepositoryImpl(ControlePedidoRepository controlepedidoRepository,
                                               ControlePedidoToControlePedidoEntityConverter converter) {
        this.controlepedidoRepository = controlepedidoRepository;
        this.converter = converter;
    }

    @Override
    public void alterar(ControlePedido controlepedido) {
        ControlePedidoEntity controlePedidoEntity = converter.convert(controlepedido);
        controlepedidoRepository.save(controlePedidoEntity);
    }
}
