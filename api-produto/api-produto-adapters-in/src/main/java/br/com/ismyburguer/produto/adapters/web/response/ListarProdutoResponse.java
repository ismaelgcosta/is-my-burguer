package br.com.ismyburguer.produto.adapters.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListarProdutoResponse {

    private String produtoId;
    private String descricao;
    private String categoria;
    private BigDecimal preco;

}
