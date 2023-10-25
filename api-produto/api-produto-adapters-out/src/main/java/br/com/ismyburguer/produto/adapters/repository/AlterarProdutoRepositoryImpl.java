package br.com.ismyburguer.produto.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.produto.adapters.converter.ProdutoToProdutoEntityConverter;
import br.com.ismyburguer.produto.adapters.entity.ProdutoEntity;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.produto.ports.out.AlterarProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class AlterarProdutoRepositoryImpl implements AlterarProdutoRepository {
    private final ProdutoRepository produtoRepository;
    private final ProdutoToProdutoEntityConverter converter;

    public AlterarProdutoRepositoryImpl(ProdutoRepository produtoRepository,
                                        ProdutoToProdutoEntityConverter converter) {
        this.produtoRepository = produtoRepository;
        this.converter = converter;
    }

    public void alterarProduto(String produtoId, @Valid Produto produto) {
        UUID uuid = UUID.fromString(produtoId);
        if(!produtoRepository.existsById(uuid)) {
            throw new EntityNotFoundException("Produto não foi encontrado");
        }

        ProdutoEntity produtoEntity = converter.convert(produto);
        produtoEntity.setProdutoId(uuid);
        produtoRepository.save(produtoEntity);
    }
}
