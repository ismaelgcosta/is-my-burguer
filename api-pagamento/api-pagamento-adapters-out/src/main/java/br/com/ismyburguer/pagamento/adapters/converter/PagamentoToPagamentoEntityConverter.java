package br.com.ismyburguer.pagamento.adapters.converter;

import br.com.ismyburguer.pagamento.adapters.entity.FormaPagamentoEntity;
import br.com.ismyburguer.pagamento.adapters.entity.PagamentoEntity;
import br.com.ismyburguer.pagamento.adapters.entity.StatusPagamentoEntity;
import br.com.ismyburguer.pagamento.adapters.entity.TipoPagamentoEntity;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class PagamentoToPagamentoEntityConverter implements Converter<Pagamento, PagamentoEntity> {
    @Override
    public PagamentoEntity convert(Pagamento source) {
        return new PagamentoEntity(
                source.getPedidoId().getPedidoId(),
                StatusPagamentoEntity.valueOf(source.getStatusPagamento().name()),
                TipoPagamentoEntity.valueOf(source.getTipoPagamento().name()),
                FormaPagamentoEntity.valueOf(source.getFormaPagamento().name()),
                source.getTotal().getValor());
    }
}
