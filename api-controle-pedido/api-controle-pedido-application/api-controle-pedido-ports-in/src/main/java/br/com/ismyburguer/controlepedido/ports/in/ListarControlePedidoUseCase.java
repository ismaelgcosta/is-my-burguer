package br.com.ismyburguer.controlepedido.ports.in;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

import java.util.List;

public interface ListarControlePedidoUseCase {

    List<ControlePedido> listar();
}
