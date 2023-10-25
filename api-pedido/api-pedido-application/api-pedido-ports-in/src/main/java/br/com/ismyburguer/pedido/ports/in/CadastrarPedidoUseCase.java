package br.com.ismyburguer.pedido.ports.in;

import br.com.ismyburguer.pedido.domain.model.Pedido;

import java.util.UUID;

public interface CadastrarPedidoUseCase {
    UUID cadastrar(Pedido pedido);
}
