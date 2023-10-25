package br.com.ismyburguer.cliente.adapters.converter;

import br.com.ismyburguer.cliente.adapters.entity.ClienteEntity;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class ClienteEntityToClienteConverter implements Converter<ClienteEntity, Cliente> {
    @Override
    public Cliente convert(ClienteEntity source) {
        return new Cliente(
                new Cliente.ClienteId(source.getClienteId()),
                new Cliente.Nome(source.getNome(), source.getSobrenome()),
                new Cliente.Email(source.getEmail()),
                source.getCpf().map(Cliente.CPF::new).orElse(null)
        );
    }
}
