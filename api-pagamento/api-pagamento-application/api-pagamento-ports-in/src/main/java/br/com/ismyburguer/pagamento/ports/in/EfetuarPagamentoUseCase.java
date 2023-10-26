package br.com.ismyburguer.pagamento.ports.in;

import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import jakarta.validation.Valid;

import java.util.UUID;

public interface EfetuarPagamentoUseCase {

    UUID pagar(@Valid Pagamento pagamento);
}
