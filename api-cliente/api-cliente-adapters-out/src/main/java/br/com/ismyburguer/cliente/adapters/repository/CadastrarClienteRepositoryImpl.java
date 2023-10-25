package br.com.ismyburguer.cliente.adapters.repository;

import br.com.ismyburguer.cliente.adapters.converter.ClienteToClienteEntityConverter;
import br.com.ismyburguer.cliente.adapters.entity.ClienteEntity;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.cliente.ports.out.CadastrarClienteRepository;
import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class CadastrarClienteRepositoryImpl implements CadastrarClienteRepository {
    private final ClienteRepository clienteRepository;
    private final ClienteToClienteEntityConverter converter;

    public CadastrarClienteRepositoryImpl(ClienteRepository clienteRepository,
                                          ClienteToClienteEntityConverter converter) {
        this.clienteRepository = clienteRepository;
        this.converter = converter;
    }

    @Override
    public UUID salvarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = converter.convert(cliente);
        return clienteRepository.save(clienteEntity).getClienteId();
    }
}
