package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.core.adapter.in.WebAdapter;
import br.com.ismyburguer.pedido.ports.in.FecharPedidoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Pedido", description = "Gerenciamento de Pedidos")
@WebAdapter
@RequestMapping("/pedidos")
public class FecharPedidoController {
    private final FecharPedidoUseCase useCase;

    public FecharPedidoController(FecharPedidoUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(description = "Fechar Pedido")
    @PutMapping("/fechamento/{pedidoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarPedido(
            @PathVariable String pedidoId
    ) {
        useCase.fechar(pedidoId);
    }

}
