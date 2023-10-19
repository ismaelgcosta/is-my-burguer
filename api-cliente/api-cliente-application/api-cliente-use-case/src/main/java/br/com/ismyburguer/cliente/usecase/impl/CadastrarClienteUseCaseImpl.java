package br.com.ismyburguer.cliente.usecase.impl;

import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.cliente.ports.in.CadastrarClienteUseCase;
import br.com.ismyburguer.cliente.ports.out.CadastrarClienteRepository;
import br.com.ismyburguer.core.usecase.UseCase;

import java.util.UUID;

@UseCase
public class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase {
    private final CadastrarClienteRepository repository;

    public CadastrarClienteUseCaseImpl(CadastrarClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID cadastrar(Cliente cliente) {
        return repository.salvarCliente(cliente);
    }
}
