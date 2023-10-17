package br.com.ismyburguer.cliente.application.port.in;

import br.com.ismyburguer.cliente.domain.model.Cliente;

public interface BuscarCliente {

    Cliente buscar(ConsultaCliente query);

    record ConsultaCliente(String email) {
    }
}
