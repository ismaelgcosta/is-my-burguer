package br.com.ismyburguer.cliente.adapter.in.web.mapper;

import br.com.ismyburguer.cliente.adapter.in.web.response.BuscarClienteResponse;
import br.com.ismyburguer.cliente.domain.adapter.in.web.mapper.WebMapper;
import br.com.ismyburguer.cliente.domain.model.Cliente;
import org.springframework.core.convert.converter.Converter;

@WebMapper
public class BuscarClienteMapper implements Converter<Cliente, BuscarClienteResponse> {
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
