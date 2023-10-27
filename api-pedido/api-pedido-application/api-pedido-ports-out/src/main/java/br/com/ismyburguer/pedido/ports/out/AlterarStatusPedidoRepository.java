package br.com.ismyburguer.pedido.ports.out;

import br.com.ismyburguer.pedido.domain.model.Pedido;
import jakarta.validation.Valid;

public interface AlterarStatusPedidoRepository {
    void alterar(Pedido.PedidoId pedidoId, Pedido.StatusPedido statusPedido);
}
