package br.com.ismyburguer.cliente.ports.out;

import br.com.ismyburguer.cliente.domain.model.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ConsultarClienteRepository {
    Optional<Cliente> obterPeloClienteId(UUID clienteId);
    Optional<Cliente> obterPeloEmail(String email);
    boolean existsById(UUID clienteId);
}
