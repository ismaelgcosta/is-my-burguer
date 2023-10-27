package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.pedido.adapters.web.converter.AlterarPedidoRequestConverter;
import br.com.ismyburguer.pedido.adapters.web.request.AlterarPedidoRequest;
import br.com.ismyburguer.pedido.ports.in.AlterarPedidoUseCase;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pedido", description = "Gerenciamento de Pedidos")
@WebAdapter
@RequestMapping("/pedidos")
public class AlterarPedidoController {
    private final AlterarPedidoUseCase useCase;
    private final AlterarPedidoRequestConverter converter;

    public AlterarPedidoController(AlterarPedidoUseCase useCase,
                                    AlterarPedidoRequestConverter converter) {
        this.useCase = useCase;
        this.converter = converter;
    }

    @Operation(description = "Alterar Pedido")
    @PutMapping("/{pedidoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarPedido(
            @PathVariable @Valid @UUID(message = "O código do pedido informado está num formato inválido") String pedidoId,
            @RequestBody AlterarPedidoRequest request
    ) {
        useCase.alterar(pedidoId, converter.convert(request));
    }

}
