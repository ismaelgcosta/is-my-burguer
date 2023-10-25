package br.com.ismyburguer.cliente.ports.out;

import br.com.ismyburguer.cliente.domain.model.Cliente;
import jakarta.validation.Valid;

public interface AlterarClienteRepository {
    void alterarCliente(String clienteId, @Valid Cliente cliente);
}
