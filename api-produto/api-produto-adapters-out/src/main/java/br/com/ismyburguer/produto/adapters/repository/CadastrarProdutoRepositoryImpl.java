package br.com.ismyburguer.produto.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.produto.adapters.converter.ProdutoToProdutoEntityConverter;
import br.com.ismyburguer.produto.adapters.entity.ProdutoEntity;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.produto.ports.out.CadastrarProdutoRepository;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class CadastrarProdutoRepositoryImpl implements CadastrarProdutoRepository {
    private final ProdutoRepository produtoRepository;
    private final ProdutoToProdutoEntityConverter converter;

    public CadastrarProdutoRepositoryImpl(ProdutoRepository produtoRepository,
                                          ProdutoToProdutoEntityConverter converter) {
        this.produtoRepository = produtoRepository;
        this.converter = converter;
    }

    @Override
    public UUID salvarProduto(Produto produto) {
        ProdutoEntity produtoEntity = converter.convert(produto);
        return produtoRepository.save(produtoEntity).getProdutoId();
    }
}
