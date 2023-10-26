package br.com.ismyburguer.pagamento.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.pagamento.ports.in.ConsultarPagamentoUseCase;
import br.com.ismyburguer.pagamento.ports.in.EfetuarPagamentoUseCase;
import br.com.ismyburguer.pagamento.ports.out.ConsultarPagamentoRepository;
import br.com.ismyburguer.pagamento.ports.out.EfetuarPagamentoRepository;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;

@UseCase
public class ConsultaPagamentoUseCaseImpl implements ConsultarPagamentoUseCase {
    private final ConsultarPagamentoRepository repository;
    public ConsultaPagamentoUseCaseImpl(ConsultarPagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pagamento consultar(@UUID String pagamentoId) {
        return repository.consultar(pagamentoId);
    }
}
