package br.com.ismyburguer.cliente.adapter.out.persistence;

import br.com.ismyburguer.cliente.adapter.out.persistence.mapper.ClienteEntityToClienteMapper;
import br.com.ismyburguer.cliente.adapter.out.persistence.repository.ClienteRepository;
import br.com.ismyburguer.cliente.application.port.in.BuscarCliente;
import br.com.ismyburguer.cliente.domain.adapter.out.persistence.PersistenceAdapter;
import br.com.ismyburguer.cliente.domain.adapter.out.persistence.exception.EntityNotFoundException;
import br.com.ismyburguer.cliente.domain.model.Cliente;

@PersistenceAdapter
class BuscarClienteAdapter implements BuscarCliente {
    private final ClienteEntityToClienteMapper mapper;
    private final ClienteRepository clienteRepository;

    BuscarClienteAdapter(ClienteEntityToClienteMapper mapper, ClienteRepository clienteRepository) {
        this.mapper = mapper;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente buscar(ConsultaCliente query) {
        return clienteRepository.findByEmailIgnoreCase(query.email())
                .map(mapper::convert)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }
}
