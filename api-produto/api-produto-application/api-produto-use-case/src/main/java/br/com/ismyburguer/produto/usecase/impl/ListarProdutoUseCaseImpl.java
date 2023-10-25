package br.com.ismyburguer.produto.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.produto.ports.in.ListarProdutoUseCase;
import br.com.ismyburguer.produto.ports.out.ListarProdutoRepository;

import java.util.Collection;

@UseCase
public class ListarProdutoUseCaseImpl implements ListarProdutoUseCase {

    private final ListarProdutoRepository repository;

    public ListarProdutoUseCaseImpl(ListarProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Produto> listar(ListarProdutoQuery query) {
        return repository.listarProdutosPorCategoria(Produto.Categoria.valueOf(query.categoria()));
    }
}
