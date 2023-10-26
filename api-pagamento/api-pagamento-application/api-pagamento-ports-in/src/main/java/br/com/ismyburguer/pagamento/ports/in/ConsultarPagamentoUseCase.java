package br.com.ismyburguer.pagamento.ports.in;

import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;

public interface ConsultarPagamentoUseCase {

    Pagamento consultar(@UUID String pagamentoId);
}
