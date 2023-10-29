package br.com.ismyburguer.produto.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.produto.adapters.converter.ProdutoEntityToProdutoConverter;
import br.com.ismyburguer.produto.adapters.entity.CategoriaEntity;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.produto.ports.out.ListarProdutoRepository;

import java.util.Collection;

@PersistenceAdapter
public class ListarProdutoRepositoryImpl implements ListarProdutoRepository {
    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityToProdutoConverter converter;

    public ListarProdutoRepositoryImpl(ProdutoRepository produtoRepository,
                                       ProdutoEntityToProdutoConverter converter) {
        this.produtoRepository = produtoRepository;
        this.converter = converter;
    }

    @Override
    public Collection<Produto> listarProdutosPorCategoria(Produto.Categoria categoria) {
        return produtoRepository
                .findAllByCategoriaAndAtivoIsTrue(CategoriaEntity.valueOf(categoria.name()))
                .stream()
                .map(converter::convert)
                .toList();
    }

}
