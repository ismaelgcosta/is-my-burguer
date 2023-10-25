package br.com.ismyburguer.pedido.adapters.web.response;

import br.com.ismyburguer.core.validation.Validation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuscarItemPedidoResponse implements Validation {

    private String itemPedidoId;
    private String produtoId;

    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal valorTotal;

}
