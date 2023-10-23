package br.com.ismyburguer.produto.ports.in;

import br.com.ismyburguer.produto.domain.model.Produto;

import java.util.UUID;

public interface CadastrarProdutoUseCase {
    UUID cadastrar(Produto produto);
}
