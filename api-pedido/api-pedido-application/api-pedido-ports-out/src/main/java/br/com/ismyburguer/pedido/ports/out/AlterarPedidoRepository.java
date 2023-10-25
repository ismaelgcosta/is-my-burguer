package br.com.ismyburguer.pedido.ports.out;

import br.com.ismyburguer.pedido.domain.model.Pedido;
import jakarta.validation.Valid;

public interface AlterarPedidoRepository {
    void alterarPedido(String pedidoId, @Valid Pedido pedido);
}
