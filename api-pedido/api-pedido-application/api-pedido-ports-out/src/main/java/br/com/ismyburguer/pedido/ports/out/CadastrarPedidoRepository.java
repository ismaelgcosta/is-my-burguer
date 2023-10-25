package br.com.ismyburguer.pedido.ports.out;

import br.com.ismyburguer.pedido.domain.model.Pedido;
import jakarta.validation.Valid;

import java.util.UUID;

public interface CadastrarPedidoRepository {
    UUID salvarPedido(@Valid Pedido pedido);
}
