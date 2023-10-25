package br.com.ismyburguer.cliente.adapters.web.converter;

import br.com.ismyburguer.cliente.adapters.web.request.CriarClienteRequest;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import jakarta.validation.ConstraintViolationException;

@WebConverter
public class CadastrarClienteRequestConverter implements Converter<CriarClienteRequest, Cliente> {

    public Cliente convert(CriarClienteRequest source) {
        if(source == null) {
            throw new ConstraintViolationException("Não foi informado o corpo da requisição", null);
        }

        if(source != null) {
            source.validate();
        }

        return new Cliente(
                new Cliente.Nome(source.getNome(), source.getSobrenome()),
                new Cliente.Email(source.getEmail()),
                source.getCpf().map(Cliente.CPF::new).orElse(null)
        );
    }
}
