package br.com.ismyburguer.produto.adapters.web.converter;

import br.com.ismyburguer.produto.adapters.web.request.CriarProdutoRequest;
import br.com.ismyburguer.produto.domain.model.Produto;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import br.com.ismyburguer.core.adapter.Converter;

@WebConverter
public class CadastrarProdutoRequestConverter implements Converter<CriarProdutoRequest, Produto> {
    public Produto convert(CriarProdutoRequest source) {

        return new Produto(
                new Produto.Descricao(source.getDescricao()),
                Produto.Categoria.valueOf(source.getCategoria()),
                new Produto.Preco(source.getPreco())
        );
    }
}
