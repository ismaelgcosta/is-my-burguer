package br.com.ismyburguer.produto.ports.out;

import br.com.ismyburguer.produto.domain.model.Produto;

import java.util.Collection;

public interface ListarProdutoRepository {
    Collection<Produto> listarProdutosPorCategoria(Produto.Categoria categoria);
}
