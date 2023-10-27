package br.com.ismyburguer.pedido.adapters.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListarControlePedidoResponse {

    private String pedidoId;
    private String status;

}
