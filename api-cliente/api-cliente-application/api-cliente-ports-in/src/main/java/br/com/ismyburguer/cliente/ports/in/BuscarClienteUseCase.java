package br.com.ismyburguer.cliente.ports.in;

import br.com.ismyburguer.cliente.domain.model.Cliente;

public interface BuscarClienteUseCase {

    Cliente buscar(ConsultaCliente query);

}
