package br.com.ismyburguer.produto.adapters.web.request;

import br.com.ismyburguer.produto.domain.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
public class CriarProdutoRequest {

    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private String cpf;
    public Optional<String> getCpf() {
        return Optional.ofNullable(cpf);
    }

}
