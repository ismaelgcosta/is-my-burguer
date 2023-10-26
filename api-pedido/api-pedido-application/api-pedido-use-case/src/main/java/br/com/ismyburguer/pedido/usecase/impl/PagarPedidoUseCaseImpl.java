package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.exception.BusinessException;
import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pagamento.domain.model.Pagamento;
import br.com.ismyburguer.pagamento.ports.in.ConsultarPagamentoUseCase;
import br.com.ismyburguer.pagamento.ports.in.EfetuarPagamentoUseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.AlterarStatusPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.ConsultarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.PagarPedidoUseCase;

import java.util.UUID;

@UseCase
public class PagarPedidoUseCaseImpl implements PagarPedidoUseCase {
    private final EfetuarPagamentoUseCase pagamentoUseCase;
    private final ConsultarPagamentoUseCase consultarPagamentoUseCase;
    private final ConsultarPedidoUseCase pedidoUseCase;
    private final AlterarStatusPedidoUseCase alterarStatusPedidoUseCase;
    public PagarPedidoUseCaseImpl(EfetuarPagamentoUseCase pagamentoUseCase,
                                  ConsultarPedidoUseCase pedidoUseCase,
                                  ConsultarPagamentoUseCase consultarPagamentoUseCase,
                                  AlterarStatusPedidoUseCase alterarStatusPedidoUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
        this.pedidoUseCase = pedidoUseCase;
        this.consultarPagamentoUseCase = consultarPagamentoUseCase;
        this.alterarStatusPedidoUseCase = alterarStatusPedidoUseCase;
    }

    @Override
    public String pagar(String pedidoId) {
        Pedido pedido = pedidoUseCase.buscarPorId(new ConsultarPedidoUseCase.ConsultaPedidoPorId(pedidoId));
//        if(pedido.getStatusPedido() != Pedido.StatusPedido.FECHADO) {
//            throw new BusinessException("Só é permitido pagar Pedidos que estiverem fechados, feche o Pedido primeiro");
//        }

        UUID uuid = pagamentoUseCase.pagar(new Pagamento(
                new Pagamento.PedidoId(pedido.getPedidoId().get().getPedidoId()),
                new Pagamento.Total(pedido.getTotal().getValor())
        ));
        Pagamento pagamento = consultarPagamentoUseCase.consultar(uuid.toString());
        Pagamento.StatusPagamento statusPagamento = pagamento.getStatusPagamento();

        switch (statusPagamento) {
            case AGUARDANDO_CONFIRMACAO -> alterarStatusPedidoUseCase.alterar(pedidoId, Pedido.StatusPedido.AGUARDANDO_PAGAMENTO);
            case NAO_AUTORIZADO -> alterarStatusPedidoUseCase.alterar(pedidoId, Pedido.StatusPedido.PAGAMENTO_NAO_AUTORIZADO);
            case PAGO -> alterarStatusPedidoUseCase.alterar(pedidoId, Pedido.StatusPedido.PAGO);
        }
        return pagamento.getQrCode();
    }
}
