package br.com.ismyburguer.cliente.usecase.impl;

import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.cliente.ports.in.AlterarClienteUseCase;
import br.com.ismyburguer.cliente.ports.out.AlterarClienteRepository;
import br.com.ismyburguer.core.usecase.UseCase;

@UseCase
public class AlterarClienteUseCaseImpl implements AlterarClienteUseCase {
    private final AlterarClienteRepository repository;

    public AlterarClienteUseCaseImpl(AlterarClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void alterar(String clienteId, Cliente cliente) {
        repository.alterarCliente(clienteId, cliente);
    }
}
