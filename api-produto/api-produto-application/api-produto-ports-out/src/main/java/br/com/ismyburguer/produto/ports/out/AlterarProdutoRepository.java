package br.com.ismyburguer.produto.ports.out;

import br.com.ismyburguer.produto.domain.model.Produto;
import jakarta.validation.Valid;

public interface AlterarProdutoRepository {
    void alterarProduto(String produtoId, @Valid Produto produto);
}
