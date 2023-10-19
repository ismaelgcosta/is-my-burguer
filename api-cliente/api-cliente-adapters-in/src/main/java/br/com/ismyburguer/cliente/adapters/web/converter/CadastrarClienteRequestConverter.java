package br.com.ismyburguer.cliente.adapters.web.converter;

import br.com.ismyburguer.cliente.adapters.web.request.CriarClienteRequest;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import org.springframework.core.convert.converter.Converter;

@WebConverter
public class CadastrarClienteRequestConverter implements Converter<CriarClienteRequest, Cliente> {
    public Cliente convert(CriarClienteRequest source) {

        return new Cliente(
                new Cliente.Nome(source.getNome(), source.getSobrenome()),
                new Cliente.Email(source.getEmail()),
                source.getCpf().map(Cliente.CPF::new).orElse(null)
        );
    }
}
