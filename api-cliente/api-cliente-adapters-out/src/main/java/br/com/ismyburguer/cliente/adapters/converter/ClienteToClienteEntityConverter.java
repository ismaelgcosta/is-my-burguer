package br.com.ismyburguer.cliente.adapters.converter;

import br.com.ismyburguer.cliente.adapters.entity.ClienteEntity;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class ClienteToClienteEntityConverter implements Converter<Cliente, ClienteEntity> {
    @Override
    public ClienteEntity convert(Cliente source) {
        return new ClienteEntity(
                source.getNome().getNome(),
                source.getNome().getSobrenome(),
                source.getEmail().getEndereco(),
                source.getCpf().map(Cliente.CPF::getNumero).orElse(null)
        );
    }
}
