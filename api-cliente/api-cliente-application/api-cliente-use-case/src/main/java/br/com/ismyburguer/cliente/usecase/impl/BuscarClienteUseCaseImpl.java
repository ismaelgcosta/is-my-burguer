package br.com.ismyburguer.cliente.usecase.impl;

import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.cliente.ports.in.BuscarClienteUseCase;
import br.com.ismyburguer.cliente.ports.in.ConsultaCliente;
import br.com.ismyburguer.cliente.ports.out.ConsultaClienteRepository;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.core.usecase.UseCase;

@UseCase
public class BuscarClienteUseCaseImpl implements BuscarClienteUseCase {

    private final ConsultaClienteRepository repository;

    public BuscarClienteUseCaseImpl(ConsultaClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente buscar(ConsultaCliente query) {
        return repository.obterPeloEmail(query.email())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não foi encontrado"));
    }
}
