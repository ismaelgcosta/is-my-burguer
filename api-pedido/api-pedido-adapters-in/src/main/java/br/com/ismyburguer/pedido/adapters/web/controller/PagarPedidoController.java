package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.core.adapter.in.WebAdapter;
import br.com.ismyburguer.pedido.adapters.web.converter.AlterarPedidoRequestConverter;
import br.com.ismyburguer.pedido.ports.in.PagarPedidoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pedido", description = "Gerenciamento de Pedidos")
@WebAdapter
@RequestMapping("/pedidos")
public class PagarPedidoController {
    private final PagarPedidoUseCase useCase;
    private final AlterarPedidoRequestConverter converter;

    public PagarPedidoController(PagarPedidoUseCase useCase,
                                 AlterarPedidoRequestConverter converter) {
        this.useCase = useCase;
        this.converter = converter;
    }

    @Operation(description = "Pagar Pedido")
    @PutMapping("/pagamento/{pedidoId}")
    public String pagarPedido(
            @PathVariable String pedidoId
    ) {
        return useCase.pagar(pedidoId);
    }

}
