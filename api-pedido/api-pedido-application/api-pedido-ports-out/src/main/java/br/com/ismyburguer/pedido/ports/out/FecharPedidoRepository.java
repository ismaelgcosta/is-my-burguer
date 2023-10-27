package br.com.ismyburguer.pedido.ports.out;

import java.util.UUID;

public interface FecharPedidoRepository {
    void fecharPedido(UUID pedidoId);
}
