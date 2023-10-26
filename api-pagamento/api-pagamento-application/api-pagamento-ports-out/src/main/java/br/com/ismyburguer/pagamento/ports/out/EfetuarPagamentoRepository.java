package br.com.ismyburguer.pagamento.ports.out;

import br.com.ismyburguer.pagamento.domain.model.Pagamento;

import java.util.UUID;

public interface EfetuarPagamentoRepository {

    UUID pagar(Pagamento pagamento);

}
