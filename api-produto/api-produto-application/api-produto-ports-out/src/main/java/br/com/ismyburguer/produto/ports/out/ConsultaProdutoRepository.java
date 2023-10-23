package br.com.ismyburguer.produto.ports.out;

import br.com.ismyburguer.produto.domain.model.Produto;

import java.util.Optional;
import java.util.UUID;

public interface ConsultaProdutoRepository {
    Optional<Produto> obterPeloProdutoId(UUID produtoId);
    Optional<Produto> obterPeloEmail(String email);
}
