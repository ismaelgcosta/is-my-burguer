package br.com.ismyburguer.cliente.ports.in;

import br.com.ismyburguer.cliente.domain.model.Cliente;

import java.util.UUID;

public interface CadastrarClienteUseCase {
    UUID cadastrar(Cliente cliente);
}
