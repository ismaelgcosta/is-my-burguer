package br.com.ismyburguer.produto.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.produto.adapters.entity.ProdutoEntity;
import br.com.ismyburguer.produto.ports.out.InativarProdutoRepository;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class InativarProdutoRepositoryImpl implements InativarProdutoRepository {
    private final ProdutoRepository produtoRepository;

    public InativarProdutoRepositoryImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void inativar(String produtoId) {
        UUID uuid = UUID.fromString(produtoId);
        ProdutoEntity produtoEntity = produtoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Produto não foi encontrado"));
        produtoEntity.setAtivo(false);
        produtoRepository.save(produtoEntity);
    }
}
