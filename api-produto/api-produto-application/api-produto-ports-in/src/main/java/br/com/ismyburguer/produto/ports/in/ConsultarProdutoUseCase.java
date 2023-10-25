package br.com.ismyburguer.produto.ports.in;

import br.com.ismyburguer.core.adapter.ExistsByIdUseCase;
import br.com.ismyburguer.produto.domain.model.Produto;

public interface ConsultarProdutoUseCase extends ExistsByIdUseCase<Produto> {

    Produto buscar(ConsultaProdutoQuery query);

    record ConsultaProdutoQuery(String produtoId) {

    }
}
