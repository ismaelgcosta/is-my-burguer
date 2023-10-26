package br.com.ismyburguer.pagamento.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.pagamento.adapters.converter.PagamentoToPagamentoEntityConverter;
import br.com.ismyburguer.pagamento.adapters.entity.PagamentoEntity;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.pagamento.ports.out.EfetuarPagamentoRepository;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@PersistenceAdapter
public class EfetuarPagamentoRepositoryImpl implements EfetuarPagamentoRepository {
    private final PagamentoRepository pagamentoRepository;
    private final PagamentoToPagamentoEntityConverter converter;

    public EfetuarPagamentoRepositoryImpl(PagamentoRepository pagamentoRepository,
                                          PagamentoToPagamentoEntityConverter converter) {
        this.pagamentoRepository = pagamentoRepository;
        this.converter = converter;
    }

    @Override
    public UUID pagar(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = converter.convert(pagamento);
        return pagamentoRepository.save(pagamentoEntity).getPagamentoId();
    }
}
