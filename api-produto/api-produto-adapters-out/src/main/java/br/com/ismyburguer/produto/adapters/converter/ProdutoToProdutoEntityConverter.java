package br.com.ismyburguer.produto.adapters.converter;

import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;
import br.com.ismyburguer.produto.adapters.entity.CategoriaEntity;
import br.com.ismyburguer.produto.adapters.entity.ProdutoEntity;
import br.com.ismyburguer.produto.domain.model.Produto;

@PersistenceConverter
public class ProdutoToProdutoEntityConverter implements Converter<Produto, ProdutoEntity> {

    @Override
    public ProdutoEntity convert(Produto source) {
        return new ProdutoEntity(
                source.getDescricao().getValor(),
                CategoriaEntity.valueOf(source.getCategoria().name()),
                source.getPreco().getValor()
        );
    }

}
