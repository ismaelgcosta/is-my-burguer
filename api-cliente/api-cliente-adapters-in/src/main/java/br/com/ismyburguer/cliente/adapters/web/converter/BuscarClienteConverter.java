package br.com.ismyburguer.cliente.adapters.web.converter;

import br.com.ismyburguer.cliente.adapters.web.response.BuscarClienteResponse;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import br.com.ismyburguer.core.adapter.Converter;

@WebConverter
public class BuscarClienteConverter implements Converter<Cliente, BuscarClienteResponse> {
    @Override
    public BuscarClienteResponse convert(Cliente source) {
        return new BuscarClienteResponse(
                source.getNome().getNome(),
                source.getNome().getSobrenome(),
                source.getCpf().map(Cliente.CPF::getNumero).orElse(null),
                source.getEmail().getEndereco()
        );
    }
}
