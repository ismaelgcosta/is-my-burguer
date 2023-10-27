package br.com.ismyburguer.controlepedido.ports.in;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface GerarControlePedidoUseCase {
    UUID receberPedido(@Valid @NotNull(message = "Informe o pedido") ControlePedido.PedidoId pedidoId);
}
