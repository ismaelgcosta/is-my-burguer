package br.com.ismyburguer.controlepedido.adapters.adapters.repository;

import br.com.ismyburguer.controlepedido.adapters.adapters.converter.ControlePedidoEntityToControlePedidoConverter;
import br.com.ismyburguer.controlepedido.adapters.adapters.entity.ControlePedidoEntity;
import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.out.out.ConsultarControlePedidoRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
public class ConsultarControlePedidoRepositoryImpl implements ConsultarControlePedidoRepository {
    private final ControlePedidoRepository controlePedidoRepository;
    private final ControlePedidoEntityToControlePedidoConverter converter;

    public ConsultarControlePedidoRepositoryImpl(ControlePedidoRepository controlePedidoRepository,
                                                 ControlePedidoEntityToControlePedidoConverter converter) {
        this.controlePedidoRepository = controlePedidoRepository;
        this.converter = converter;
    }

    @Override
    public Optional<ControlePedido> consultar(UUID pedidoId) {
        Optional<ControlePedidoEntity> clienteEntity = controlePedidoRepository.findByPedidoId(pedidoId);
        return clienteEntity.map(converter::convert);
    }

}
