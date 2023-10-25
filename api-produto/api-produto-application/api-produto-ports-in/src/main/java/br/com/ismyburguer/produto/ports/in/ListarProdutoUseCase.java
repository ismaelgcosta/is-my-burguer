package br.com.ismyburguer.produto.ports.in;

import br.com.ismyburguer.produto.domain.model.Produto;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;

public interface ListarProdutoUseCase {

    Collection<Produto> listar(ListarProdutoQuery query);
    record ListarProdutoQuery(@NotNull(message = "Informe a categoria para realizar a consulta") String categoria) {

    }
}
