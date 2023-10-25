package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.pedido.adapters.web.converter.BuscarPedidoConverter;
import br.com.ismyburguer.pedido.adapters.web.response.BuscarPedidoResponse;
import br.com.ismyburguer.pedido.ports.in.ConsultarPedidoUseCase;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Pedido", description = "Gerenciamento de Pedidos")
@WebAdapter
@RequestMapping("/pedidos")
public class BuscarPedidoController {
    private final ConsultarPedidoUseCase consultarPedidoUseCase;
    private final BuscarPedidoConverter buscarPedidoConverter;

    public BuscarPedidoController(ConsultarPedidoUseCase consultarPedidoUseCase,
                                   BuscarPedidoConverter buscarPedidoConverter) {
        this.consultarPedidoUseCase = consultarPedidoUseCase;
        this.buscarPedidoConverter = buscarPedidoConverter;
    }

    @Operation(description = "Consultar Pedido por Email")
    @GetMapping("/{pedidoId}")
    public BuscarPedidoResponse obter(@PathVariable(name = "pedidoId") String pedidoId) {
        return buscarPedidoConverter.convert(consultarPedidoUseCase.buscarPorId(new ConsultarPedidoUseCase.ConsultaPedidoPorId(pedidoId)));
    }

}
