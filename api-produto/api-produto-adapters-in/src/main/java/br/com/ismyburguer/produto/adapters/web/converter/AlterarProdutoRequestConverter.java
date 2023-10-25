package br.com.ismyburguer.produto.adapters.web.converter;

import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.in.WebConverter;
import br.com.ismyburguer.produto.adapters.web.request.AlterarProdutoRequest;
import br.com.ismyburguer.produto.domain.model.Produto;
import jakarta.validation.ConstraintViolationException;

import java.util.UUID;

@WebConverter
public class AlterarProdutoRequestConverter implements Converter<AlterarProdutoRequest, Produto> {
    public Produto convert(AlterarProdutoRequest source) {
        if(source == null) {
            throw new ConstraintViolationException("Não foi informado o corpo da requisição", null);
        }

        if(source != null) {
            source.validate();
        }

        return new Produto(
                new Produto.Descricao(source.getDescricao()),
                Produto.Categoria.valueOf(source.getCategoria()),
                new Produto.Preco(source.getPreco())
        );
    }
}
