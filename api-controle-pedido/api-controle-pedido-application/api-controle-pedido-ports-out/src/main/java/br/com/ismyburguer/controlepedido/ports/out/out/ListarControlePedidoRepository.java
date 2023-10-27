package br.com.ismyburguer.controlepedido.ports.out.out;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

import java.util.List;

public interface ListarControlePedidoRepository {

    List<ControlePedido> listar();

}
