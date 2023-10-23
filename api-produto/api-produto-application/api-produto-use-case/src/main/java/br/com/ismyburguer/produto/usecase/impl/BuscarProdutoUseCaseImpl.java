package br.com.ismyburguer.produto.usecase.impl;

import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.produto.ports.in.BuscarProdutoUseCase;
import br.com.ismyburguer.produto.ports.in.ConsultaProduto;
import br.com.ismyburguer.produto.ports.out.ConsultaProdutoRepository;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.core.usecase.UseCase;

@UseCase
public class BuscarProdutoUseCaseImpl implements BuscarProdutoUseCase {

    private final ConsultaProdutoRepository repository;

    public BuscarProdutoUseCaseImpl(ConsultaProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto buscar(ConsultaProduto query) {
        return repository.obterPeloEmail(query.email())
                .orElseThrow(() -> new EntityNotFoundException("Produto não foi encontrado"));
    }
}
