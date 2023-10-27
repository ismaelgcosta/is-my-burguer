package br.com.ismyburguer.controlepedido.adapters.adapters.repository;

import br.com.ismyburguer.controlepedido.adapters.adapters.converter.ControlePedidoEntityToControlePedidoConverter;
import br.com.ismyburguer.controlepedido.adapters.adapters.entity.StatusControlePedidoEntity;
import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.out.out.ListarControlePedidoRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;

@PersistenceAdapter
public class ListarControlePedidoRepositoryImpl implements ListarControlePedidoRepository {
    private final ControlePedidoRepository controlePedidoRepository;
    private final ControlePedidoEntityToControlePedidoConverter converter;

    public ListarControlePedidoRepositoryImpl(ControlePedidoRepository controlePedidoRepository,
                                              ControlePedidoEntityToControlePedidoConverter converter) {
        this.controlePedidoRepository = controlePedidoRepository;
        this.converter = converter;
    }

    @Override
    public List<ControlePedido> listar() {
        return controlePedidoRepository.findAllByStatusControlePedidoNot(StatusControlePedidoEntity.RETIRADO)
                .stream()
                .map(converter::convert)
                .sorted(Comparator.comparing(ControlePedido::getRecebidoEm))
                .toList();
    }
}
