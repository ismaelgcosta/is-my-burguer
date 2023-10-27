package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.in.RetirarControlePedidoUseCase;
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
public class RetirarControlePedidoController {
    private final RetirarControlePedidoUseCase useCase;

    public RetirarControlePedidoController(RetirarControlePedidoUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(description = "Retirar Pedido")
    @PutMapping("/{pedidoId}/retirada")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void retirarPedido(
            @PathVariable @Valid @UUID(message = "O código do pedido informado está num formato inválido") String pedidoId
    ) {
        useCase.retirar(new ControlePedido.PedidoId(pedidoId));
    }

}
