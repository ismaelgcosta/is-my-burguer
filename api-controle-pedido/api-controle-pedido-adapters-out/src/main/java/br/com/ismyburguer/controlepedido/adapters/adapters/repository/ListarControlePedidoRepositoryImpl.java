package br.com.ismyburguer.controlepedido.adapters.adapters.repository;

import br.com.ismyburguer.controlepedido.adapters.adapters.converter.ControlePedidoEntityToControlePedidoConverter;
import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.out.out.ListarControlePedidoRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import org.springframework.data.domain.Sort;

import java.util.List;

@PersistenceAdapter
public class ListarControlePedidoRepositoryImpl implements ListarControlePedidoRepository {
    private final ControlePedidoRepository controlepedidoRepository;
    private final ControlePedidoEntityToControlePedidoConverter converter;

    public ListarControlePedidoRepositoryImpl(ControlePedidoRepository controlepedidoRepository,
                                              ControlePedidoEntityToControlePedidoConverter converter) {
        this.controlepedidoRepository = controlepedidoRepository;
        this.converter = converter;
    }

    @Override
    public List<ControlePedido> listar() {
        return controlepedidoRepository.findAll(Sort.by("recebidoEm"))
                .stream()
                .map(converter::convert)
                .toList();
    }
}
