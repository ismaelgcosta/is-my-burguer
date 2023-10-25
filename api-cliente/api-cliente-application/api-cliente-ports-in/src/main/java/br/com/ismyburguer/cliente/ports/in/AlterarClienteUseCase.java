package br.com.ismyburguer.cliente.ports.in;

import br.com.ismyburguer.cliente.domain.model.Cliente;

public interface AlterarClienteUseCase {
    void alterar(String clienteId, Cliente cliente);
}
