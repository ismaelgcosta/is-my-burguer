package br.com.ismyburguer.cliente.ports.out;

import br.com.ismyburguer.cliente.domain.model.Cliente;
import jakarta.validation.Valid;

import java.util.UUID;

public interface CadastrarClienteRepository {
    UUID salvarCliente(@Valid Cliente cliente);
}
