package br.com.ismyburguer.controlepedido.usecase.impl.impl;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.controlepedido.ports.in.ListarControlePedidoUseCase;
import br.com.ismyburguer.controlepedido.ports.out.out.ListarControlePedidoRepository;

import java.util.List;

@UseCase
public class ListarControlePedidoUseCaseImpl implements ListarControlePedidoUseCase {
    private final ListarControlePedidoRepository repository;
    public ListarControlePedidoUseCaseImpl(ListarControlePedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ControlePedido> listar() {
        return repository.listar();
    }
}
