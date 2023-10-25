package br.com.ismyburguer.pedido.domain.model;


import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Pedido implements Validation {

    private PedidoId pedidoId;

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

    @Getter
    public enum StatusPedido {

        ABERTO("Aberto"),
        FECHADO("Fechado"),
        PAGO("Pago"),
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
    }

    @Getter
    @AllArgsConstructor
    public static class PedidoId {

        @NotNull(message = "Informe o código do Pedido")
        @org.hibernate.validator.constraints.UUID(message = "o id informado está num formato inválido")
        private UUID pedidoId;

    }

    @Getter
    @AllArgsConstructor
    public static class ClienteId {

        @NotNull(message = "Informe o código do Cliente")
        @org.hibernate.validator.constraints.UUID(message = "o id informado está num formato inválido")
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
}
