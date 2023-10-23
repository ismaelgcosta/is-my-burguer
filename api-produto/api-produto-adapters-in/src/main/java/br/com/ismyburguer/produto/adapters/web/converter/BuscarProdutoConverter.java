package br.com.ismyburguer.produto.adapters.web.converter;

import br.com.ismyburguer.produto.adapters.web.response.BuscarProdutoResponse;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import br.com.ismyburguer.core.adapter.Converter;

@WebConverter
public class BuscarProdutoConverter implements Converter<Produto, BuscarProdutoResponse> {

    @Override
    public BuscarProdutoResponse convert(Produto source) {
        return new BuscarProdutoResponse(
                source.getDescricao().getValor(),
                source.getCategoria().name(),
                source.getPreco().getValor()
        );
    }

}
