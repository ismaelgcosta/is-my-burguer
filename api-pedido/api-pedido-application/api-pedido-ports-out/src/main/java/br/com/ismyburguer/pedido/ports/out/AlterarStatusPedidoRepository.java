package br.com.ismyburguer.pedido.ports.out;

import br.com.ismyburguer.pedido.domain.model.Pedido;
import jakarta.validation.Valid;

public interface AlterarStatusPedidoRepository {
    void alterar(String pedidoId, Pedido.StatusPedido statusPedido);
}
