package br.com.ismyburguer.cliente.adapters.web.controller;


import br.com.ismyburguer.cliente.adapters.web.converter.BuscarClienteConverter;
import br.com.ismyburguer.cliente.adapters.web.response.BuscarClienteResponse;
import br.com.ismyburguer.cliente.ports.in.ConsultarClienteUseCase;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Cliente", description = "Gerenciamento de Clientes")
@WebAdapter
@RequestMapping("/clientes")
public class BuscarClienteController {
    private final ConsultarClienteUseCase consultarClienteUseCase;
    private final BuscarClienteConverter buscarClienteConverter;

    public BuscarClienteController(ConsultarClienteUseCase consultarClienteUseCase,
                                   BuscarClienteConverter buscarClienteConverter) {
        this.consultarClienteUseCase = consultarClienteUseCase;
        this.buscarClienteConverter = buscarClienteConverter;
    }

    @Operation(description = "Consultar Cliente por Email")
    @GetMapping("/email/{email}")
    public BuscarClienteResponse obterCliente(@PathVariable(name = "email") String email) {
        return buscarClienteConverter.convert(consultarClienteUseCase.buscar(new ConsultarClienteUseCase.ConsultaCliente(email)));
    }

    @Operation(description = "Consultar Cliente por Email")
    @GetMapping("/{clienteId}")
    public BuscarClienteResponse obterClientePorId(@PathVariable(name = "clienteId") String clienteId) {
        return buscarClienteConverter.convert(consultarClienteUseCase.buscarPorId(new ConsultarClienteUseCase.ConsultaClientePorId(clienteId)));
    }

}
