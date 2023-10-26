package br.com.ismyburguer.pagamento.adapters.converter;

import br.com.ismyburguer.pagamento.adapters.entity.PagamentoEntity;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.core.adapter.Converter;
import br.com.ismyburguer.core.adapter.out.PersistenceConverter;

@PersistenceConverter
public class PagamentoEntityToPagamentoConverter implements Converter<PagamentoEntity, Pagamento> {
    @Override
    public Pagamento convert(PagamentoEntity source) {
        return new Pagamento(
                new Pagamento.PedidoId(source.getPedidoId()),
                new Pagamento.Total(source.getValorTotal()),
                Pagamento.StatusPagamento.valueOf(source.getStatusPagamento().name()),
                Pagamento.FormaPagamento.valueOf(source.getFormaPagamento().name()),
                Pagamento.TipoPagamento.valueOf(source.getTipoPagamento().name()),
                source.getQrCode()
        );
    }
}
