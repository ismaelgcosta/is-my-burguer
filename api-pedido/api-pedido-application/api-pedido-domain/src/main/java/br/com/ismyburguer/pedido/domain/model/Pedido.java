package br.com.ismyburguer.pedido.domain.model;


import br.com.ismyburguer.core.exception.BusinessException;
import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Pedido implements Validation {

    @Valid
    private PedidoId pedidoId;

    @Valid
    private ClienteId clienteId;

    private StatusPedido statusPedido = StatusPedido.ABERTO;

    @Size(min = 1, message = "É necessário informar ao menos um item no pedido")
    private final List<ItemPedido> itens;

    public Pedido(PedidoId pedidoId, List<ItemPedido> itens) {
        this.pedidoId = pedidoId;
        this.itens = itens;
    }

    public Pedido(ClienteId clienteId, List<ItemPedido> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }

    public Pedido(ClienteId clienteId, StatusPedido statusPedido, List<ItemPedido> itens) {
        this.clienteId = clienteId;
        this.statusPedido = statusPedido;
        this.itens = itens;
    }

    public Pedido(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void alterarStatus(StatusPedido statusPedido) {
        if(this.statusPedido != null) {
            this.statusPedido.validarProximoStatus(statusPedido);
        }
        this.statusPedido = statusPedido;
    }

    @Getter
    public enum StatusPedido {

        ABERTO("Aberto"),
        FECHADO("Fechado"),
        AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
        PAGO("Pago"),
        PAGAMENTO_NAO_AUTORIZADO("Pagamento Não Autorizado"),
        RECEBIDO("Recebido"),
        EM_PREPARACAO("Em Preparação"),
        PRONTO("Pronto"),
        FINALIZADO("Finalizado");

        private final String descricao;

        StatusPedido(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }

        public void validarProximoStatus(StatusPedido statusPedido) {
            String message = "O Pedido precisa estar com o Status {0} para poder ser alterado para " + statusPedido.getDescricao();

            if(statusPedido == EM_PREPARACAO && this != RECEBIDO) {
                throw new BusinessException(MessageFormat.format(message, RECEBIDO.getDescricao()));
            }

            if(statusPedido == FECHADO && this != ABERTO) {
                throw new BusinessException(MessageFormat.format(message, ABERTO.getDescricao()));
            }

            if(statusPedido == PAGO && this != AGUARDANDO_PAGAMENTO && this != PAGAMENTO_NAO_AUTORIZADO) {
                throw new BusinessException(MessageFormat.format(message, AGUARDANDO_PAGAMENTO.getDescricao() + " ou " + PAGAMENTO_NAO_AUTORIZADO.getDescricao()));
            }

            if(statusPedido == PRONTO && this != EM_PREPARACAO) {
                throw new BusinessException(MessageFormat.format(message, EM_PREPARACAO.getDescricao()));
            }

            if(statusPedido == FINALIZADO && this != PRONTO) {
                throw new BusinessException(MessageFormat.format(message, PRONTO.getDescricao()));
            }
        }

    }

    @Getter
    @AllArgsConstructor
    public static class PedidoId {

        @NotNull(message = "Informe o código do Pedido")
        private UUID pedidoId;

        public PedidoId(String pedidoId) {
            this.pedidoId = UUID.fromString(pedidoId);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ClienteId {

        @NotNull(message = "Informe o código do Cliente")
        private UUID clienteId;

    }

    @Getter
    @AllArgsConstructor
    public static class Total {

        @NotNull(message = "Informe o preço do item")
        @DecimalMin(value = "0.01", message = "O valor total do item deve ser de no mínimo R$0,01")
        private BigDecimal valor;

    }

    public Total getTotal() {
        validate();
        return new Total(itens.stream().map(ItemPedido::getTotal).map(ItemPedido.Total::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public Optional<ClienteId> getClienteId() {
        return Optional.ofNullable(clienteId);
    }

    public Optional<PedidoId> getPedidoId() {
        return Optional.ofNullable(pedidoId);
    }
}
