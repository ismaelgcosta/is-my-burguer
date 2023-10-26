package br.com.ismyburguer.pagamento.ports.out;

import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import org.hibernate.validator.constraints.UUID;

public interface ConsultarPagamentoRepository {

    Pagamento consultar(@UUID String pagamentoId);

}
