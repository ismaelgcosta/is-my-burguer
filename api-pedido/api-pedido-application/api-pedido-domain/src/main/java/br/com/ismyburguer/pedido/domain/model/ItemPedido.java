package br.com.ismyburguer.pedido.domain.model;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ItemPedido implements Validation {

    private ItemPedidoId itemPedidoId;

    @NotNull(message = "Informe o código do Pedido")
    private Pedido.PedidoId pedidoId;

    @NotNull(message = "Informe o código do Produto")
    private ProdutoId produtoId;

    @NotNull(message = "Informe a quantidade do item")
    private Quantidade quantidade;

    @NotNull(message = "Informe o preço do item")
    private Preco preco;

    public ItemPedido(ProdutoId produtoId, Quantidade quantidade, Preco preco) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Getter
    @AllArgsConstructor
    public static class ItemPedidoId {

        @NotNull(message = "Informe o código do Item do Pedido")
        @org.hibernate.validator.constraints.UUID(message = "o id informado está num formato inválido")
        private UUID itemPedidoId;

    }

    @Getter
    @AllArgsConstructor
    public static class Preco {

        @NotNull(message = "Informe o preço do item")
        @DecimalMin(value = "0.01", message = "O preço do item deve ser de no mínimo R$0,01")
        private BigDecimal valor;

    }

    @Getter
    @AllArgsConstructor
    public static class Quantidade {

        @NotNull(message = "Informe o preço do item")
        @Min(value = 1, message = "A quantidade do item do pedido deve ser de no mínimo 1")
        private Integer valor;

    }

    @Getter
    @AllArgsConstructor
    public static class Total {

        @NotNull(message = "Informe o preço do item")
        @DecimalMin(value = "0.01", message = "O valor total do item deve ser de no mínimo R$0,01")
        private BigDecimal valor;

    }

    @Getter
    @AllArgsConstructor
    public static class ProdutoId {

        @NotNull(message = "Informe o código do Produto")
        private UUID produtoId;

    }

    public Total getTotal() {
        validate();
        return new Total(this.preco.getValor().multiply(BigDecimal.valueOf(quantidade.getValor())));
    }

    public Optional<ItemPedidoId> getItemPedidoId() {
        return Optional.ofNullable(itemPedidoId);
    }

}
