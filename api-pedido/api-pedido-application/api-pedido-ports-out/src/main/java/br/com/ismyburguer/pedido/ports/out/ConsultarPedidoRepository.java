package br.com.ismyburguer.pedido.ports.out;

import br.com.ismyburguer.pedido.domain.model.Pedido;

import java.util.Optional;
import java.util.UUID;

public interface ConsultarPedidoRepository {
    Optional<Pedido> obterPeloPedidoId(UUID pedidoId);
}
