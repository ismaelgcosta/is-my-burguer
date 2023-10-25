package br.com.ismyburguer.produto.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.produto.adapters.converter.ProdutoEntityToProdutoConverter;
import br.com.ismyburguer.produto.adapters.entity.ProdutoEntity;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.produto.ports.out.ConsultaProdutoRepository;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
public class ConsultaProdutoRepositoryImpl implements ConsultaProdutoRepository {
    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityToProdutoConverter converter;

    public ConsultaProdutoRepositoryImpl(ProdutoRepository produtoRepository,
                                         ProdutoEntityToProdutoConverter converter) {
        this.produtoRepository = produtoRepository;
        this.converter = converter;
    }

    @Override
    public Optional<Produto> obterPeloProdutoId(UUID produtoId) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(produtoId);
        return produtoEntity.map(converter::convert);
    }

    @Override
    public boolean existsById(UUID produtoId) {
        return produtoRepository.existsById(produtoId);
    }

}
