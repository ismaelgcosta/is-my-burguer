package br.com.ismyburguer.produto.ports.out;

import br.com.ismyburguer.produto.domain.model.Produto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface CadastrarProdutoRepository {
    UUID salvarProduto(@Valid Produto produto);
}
