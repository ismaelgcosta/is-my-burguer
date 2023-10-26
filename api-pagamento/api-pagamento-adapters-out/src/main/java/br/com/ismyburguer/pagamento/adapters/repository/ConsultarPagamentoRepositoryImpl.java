package br.com.ismyburguer.pagamento.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.pagamento.adapters.converter.PagamentoEntityToPagamentoConverter;
import br.com.ismyburguer.pagamento.adapters.entity.PagamentoEntity;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.pagamento.ports.out.ConsultarPagamentoRepository;
import org.hibernate.validator.constraints.UUID;

@PersistenceAdapter
public class ConsultarPagamentoRepositoryImpl implements ConsultarPagamentoRepository {
    private final PagamentoRepository pagamentoRepository;
    private final PagamentoEntityToPagamentoConverter converter;

    public ConsultarPagamentoRepositoryImpl(PagamentoRepository pagamentoRepository,
                                            PagamentoEntityToPagamentoConverter converter) {
        this.pagamentoRepository = pagamentoRepository;
        this.converter = converter;
    }

    @Override
    public Pagamento consultar(@UUID String pagamentoId) {
        PagamentoEntity pagamento = pagamentoRepository.findById(java.util.UUID.fromString(pagamentoId))
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado"));
        return converter.convert(pagamento);
    }
}
