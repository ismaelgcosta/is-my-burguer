package br.com.ismyburguer.cliente.adapters.web.controller;


import br.com.ismyburguer.cliente.adapters.web.converter.BuscarClienteConverter;
import br.com.ismyburguer.cliente.adapters.web.response.BuscarClienteResponse;
import br.com.ismyburguer.cliente.ports.in.BuscarClienteUseCase;
import br.com.ismyburguer.cliente.ports.in.ConsultaCliente;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@WebAdapter
@RequestMapping("/clientes")
public class BuscarClienteController {
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final BuscarClienteConverter buscarClienteConverter;

    public BuscarClienteController(BuscarClienteUseCase buscarClienteUseCase,
                                   BuscarClienteConverter buscarClienteConverter) {
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.buscarClienteConverter = buscarClienteConverter;
    }

    @GetMapping("/{email}")
    public BuscarClienteResponse obterCliente(@PathVariable(name = "email") String email) {
        return buscarClienteConverter.convert(buscarClienteUseCase.buscar(new ConsultaCliente(email)));
    }

}
