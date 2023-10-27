package br.com.ismyburguer.controlepedido.ports.out.out;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

import java.util.Optional;
import java.util.UUID;

public interface ConsultarControlePedidoRepository {
    Optional<ControlePedido> consultar(UUID pedidoId);

}
