package br.com.ismyburguer.produto.ports.in;

import br.com.ismyburguer.produto.domain.model.Produto;

public interface AlterarProdutoUseCase {
    void alterar(String produtoId, Produto produto);
}
