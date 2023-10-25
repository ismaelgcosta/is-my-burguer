package br.com.ismyburguer.cliente.adapters.repository;

import br.com.ismyburguer.cliente.adapters.converter.ClienteToClienteEntityConverter;
import br.com.ismyburguer.cliente.adapters.entity.ClienteEntity;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.cliente.ports.out.AlterarClienteRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class AlterarClienteRepositoryImpl implements AlterarClienteRepository {
    private final ClienteRepository clienteRepository;
    private final ClienteToClienteEntityConverter converter;

    public AlterarClienteRepositoryImpl(ClienteRepository clienteRepository,
                                        ClienteToClienteEntityConverter converter) {
        this.clienteRepository = clienteRepository;
        this.converter = converter;
    }

    public void alterarCliente(String clienteId, @Valid Cliente cliente) {
        UUID uuid = UUID.fromString(clienteId);
        if(!clienteRepository.existsById(uuid)) {
            throw new EntityNotFoundException("Cliente não foi encontrado");
        }

        ClienteEntity clienteEntity = converter.convert(cliente);
        clienteEntity.setClienteId(uuid);
        clienteRepository.save(clienteEntity);
    }
}
