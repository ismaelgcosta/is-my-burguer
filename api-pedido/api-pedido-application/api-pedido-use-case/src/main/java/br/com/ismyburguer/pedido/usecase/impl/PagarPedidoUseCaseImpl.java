package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.exception.BusinessException;
import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.pagamento.ports.in.ConsultarPagamentoUseCase;
import br.com.ismyburguer.pagamento.ports.in.EfetuarPagamentoUseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.ConsultarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.PagarPedidoUseCase;

import java.util.UUID;

@UseCase
public class PagarPedidoUseCaseImpl implements PagarPedidoUseCase {
    private final EfetuarPagamentoUseCase pagamentoUseCase;
    private final ConsultarPagamentoUseCase consultarPagamentoUseCase;
    private final ConsultarPedidoUseCase pedidoUseCase;
    private final AlterarPedidoUseCase alterarPedidoUseCase;
    public PagarPedidoUseCaseImpl(EfetuarPagamentoUseCase pagamentoUseCase,
                                  ConsultarPedidoUseCase pedidoUseCase,
                                  ConsultarPagamentoUseCase consultarPagamentoUseCase,
                                  AlterarPedidoUseCase alterarPedidoUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
        this.pedidoUseCase = pedidoUseCase;
        this.consultarPagamentoUseCase = consultarPagamentoUseCase;
        this.alterarPedidoUseCase = alterarPedidoUseCase;
    }

    @Override
    public String pagar(String pedidoId) {
        Pedido pedido = pedidoUseCase.buscarPorId(new ConsultarPedidoUseCase.ConsultaPedidoPorId(pedidoId));
        UUID uuid = pagamentoUseCase.pagar(new Pagamento(
                new Pagamento.PedidoId(pedido.getPedidoId().getPedidoId()),
                new Pagamento.Total(pedido.getTotal().getValor())
        ));
        Pagamento pagamento = consultarPagamentoUseCase.consultar(uuid.toString());
        Pagamento.StatusPagamento statusPagamento = pagamento.getStatusPagamento();

        switch (statusPagamento) {
            case AGUARDANDO_CONFIRMACAO -> pedido.alterarStatus(Pedido.StatusPedido.AGUARDANDO_PAGAMENTO);
            case NAO_AUTORIZADO -> pedido.alterarStatus(Pedido.StatusPedido.PAGAMENTO_NAO_AUTORIZADO);
            case PAGO -> pedido.alterarStatus(Pedido.StatusPedido.PAGO);
        }
        alterarPedidoUseCase.alterar(pedidoId, pedido);
        return pagamento.getQrCode();
    }
}
