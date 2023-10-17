package br.com.ismyburguer.cliente.adapter.in.web;

import br.com.ismyburguer.cliente.adapter.in.web.mapper.BuscarClienteMapper;
import br.com.ismyburguer.cliente.adapter.in.web.response.BuscarClienteResponse;
import br.com.ismyburguer.cliente.application.port.in.BuscarCliente;
import br.com.ismyburguer.cliente.application.port.out.CadastrarClienteUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final BuscarCliente buscarCliente;
    private final BuscarClienteMapper buscarClienteMapper;
    private final CadastrarClienteUseCase cadastrarClienteUseCase;

    public ClienteController(BuscarCliente buscarCliente,
                             BuscarClienteMapper buscarClienteMapper,
                             CadastrarClienteUseCase cadastrarClienteUseCase) {
        this.buscarCliente = buscarCliente;
        this.buscarClienteMapper = buscarClienteMapper;
        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
    }

    @GetMapping("/{email}")
    public BuscarClienteResponse obterCliente(@PathVariable(name = "email") String email) {
        return buscarClienteMapper.convert(buscarCliente.buscar(new BuscarCliente.ConsultaCliente(email)));
    }

}
