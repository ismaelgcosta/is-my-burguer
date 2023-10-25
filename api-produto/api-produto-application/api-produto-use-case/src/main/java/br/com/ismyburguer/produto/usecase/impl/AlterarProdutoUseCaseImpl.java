package br.com.ismyburguer.produto.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.produto.ports.in.AlterarProdutoUseCase;
import br.com.ismyburguer.produto.ports.out.AlterarProdutoRepository;

import java.util.UUID;

@UseCase
public class AlterarProdutoUseCaseImpl implements AlterarProdutoUseCase {
    private final AlterarProdutoRepository repository;

    public AlterarProdutoUseCaseImpl(AlterarProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void alterar(String produtoId, Produto produto) {
        produto.setProdutoId(new Produto.ProdutoId(UUID.fromString(produtoId)));
        repository.alterarProduto(produtoId, produto);
    }
}
