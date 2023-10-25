package br.com.ismyburguer.cliente.adapters.repository;

import br.com.ismyburguer.cliente.adapters.converter.ClienteEntityToClienteConverter;
import br.com.ismyburguer.cliente.adapters.entity.ClienteEntity;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.cliente.ports.out.ConsultarClienteRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
public class ConsultarClienteRepositoryImpl implements ConsultarClienteRepository {
    private final ClienteRepository clienteRepository;
    private final ClienteEntityToClienteConverter converter;

    public ConsultarClienteRepositoryImpl(ClienteRepository clienteRepository,
                                          ClienteEntityToClienteConverter converter) {
        this.clienteRepository = clienteRepository;
        this.converter = converter;
    }

    @Override
    public Optional<Cliente> obterPeloClienteId(UUID clienteId) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(clienteId);
        return clienteEntity.map(converter::convert);
    }

    @Override
    public Optional<Cliente> obterPeloEmail(String email) {
        return clienteRepository.findByEmail(email)
                .map(converter::convert);
    }

    @Override
    public boolean existsById(UUID clienteId) {
        return clienteRepository.existsById(clienteId);
    }
}
