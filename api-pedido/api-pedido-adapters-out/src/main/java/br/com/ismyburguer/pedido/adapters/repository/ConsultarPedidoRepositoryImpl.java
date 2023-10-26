package br.com.ismyburguer.pedido.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.pedido.adapters.converter.PedidoEntityToPedidoConverter;
import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.out.ConsultarPedidoRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
public class ConsultarPedidoRepositoryImpl implements ConsultarPedidoRepository {
    private final PedidoRepository pedidoRepository;
    private final PedidoEntityToPedidoConverter converter;

    public ConsultarPedidoRepositoryImpl(PedidoRepository pedidoRepository,
                                          PedidoEntityToPedidoConverter converter) {
        this.pedidoRepository = pedidoRepository;
        this.converter = converter;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Optional<Pedido> obterPeloPedidoId(UUID pedidoId) {
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(pedidoId);
        return pedidoEntity.map(converter::convert);
    }

}
