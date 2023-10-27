package br.com.ismyburguer.controlepedido.ports.out.out;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

import java.util.UUID;

public interface GerarControlePedidoRepository {

    UUID gerar(ControlePedido controlepedido);

}
