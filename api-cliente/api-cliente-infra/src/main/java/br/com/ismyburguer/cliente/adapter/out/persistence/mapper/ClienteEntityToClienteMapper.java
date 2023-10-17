package br.com.ismyburguer.cliente.adapter.out.persistence.mapper;

import br.com.ismyburguer.cliente.adapter.in.web.response.BuscarClienteResponse;
import br.com.ismyburguer.cliente.adapter.out.persistence.entity.ClienteEntity;
import br.com.ismyburguer.cliente.domain.adapter.in.web.mapper.WebMapper;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import org.springframework.core.convert.converter.Converter;

@WebMapper
public class ClienteEntityToClienteMapper implements Converter<ClienteEntity, Cliente> {
    @Override
    public Cliente convert(ClienteEntity source) {
        return new Cliente(
                new Cliente.Nome(source.getNome(), source.getSobrenome()),
                new Cliente.Email(source.getEmail()),
                source.getCpf().map(Cliente.CPF::new).orElse(null)
        );
    }
}
