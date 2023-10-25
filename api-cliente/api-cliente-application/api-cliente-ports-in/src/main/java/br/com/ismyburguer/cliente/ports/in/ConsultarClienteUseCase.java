package br.com.ismyburguer.cliente.ports.in;

import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.core.adapter.ExistsByIdUseCase;

import java.util.UUID;

public interface ConsultarClienteUseCase extends ExistsByIdUseCase<Cliente> {

    Cliente buscar(ConsultaCliente query);
    Cliente buscarPorId(ConsultaClientePorId query);

    record ConsultaCliente(String email) {

    }
    record ConsultaClientePorId(String clienteId) {

    }
}
