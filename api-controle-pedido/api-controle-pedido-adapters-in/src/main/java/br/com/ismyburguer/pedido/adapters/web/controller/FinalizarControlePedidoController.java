package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.in.FinalizarControlePedidoUseCase;
import br.com.ismyburguer.controlepedido.ports.in.PrepararControlePedidoUseCase;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Controle de Pedidos", description = "Controle de Pedidos")
@WebAdapter
@RequestMapping("/controle-pedidos")
public class FinalizarControlePedidoController {
    private final FinalizarControlePedidoUseCase useCase;

    public FinalizarControlePedidoController(FinalizarControlePedidoUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(description = "Pedido Pronto")
    @PutMapping("/{pedidoId}/pronto")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pedidoPronto(
            @PathVariable @Valid @UUID(message = "O código do pedido informado está num formato inválido") String pedidoId
    ) {
        useCase.finalizar(new ControlePedido.PedidoId(java.util.UUID.fromString(pedidoId)));
    }

}
