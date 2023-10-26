package br.com.ismyburguer.pagamento.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.pagamento.ports.in.EfetuarPagamentoUseCase;
import br.com.ismyburguer.pagamento.ports.out.EfetuarPagamentoRepository;
import jakarta.validation.Valid;

import java.util.UUID;

@UseCase
public class EfetuarPagamentoUseCaseImpl implements EfetuarPagamentoUseCase {
    private final EfetuarPagamentoRepository repository;
    public EfetuarPagamentoUseCaseImpl(EfetuarPagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID pagar(@Valid Pagamento pagamento) {
        pagamento.validate();
        pagamento.setQrCode("cTVhbGd4eHBzc3Bsd2UzdWZhb2doN3V1YnY3eXg4YjM3Nm8yYmpzaTZybjBtY3VqbzlnaTZ6Zm9jdTd3ZHJnazVzeXMyZWw5bDRwODQwcHF5Z2ozaDUyazB0cWtuZ252N2FiY2d3Z2Mxb2N1dTR5ZHQzY3k0emNnbW10ajV5dmY=");
        return repository.pagar(pagamento);
    }
}
