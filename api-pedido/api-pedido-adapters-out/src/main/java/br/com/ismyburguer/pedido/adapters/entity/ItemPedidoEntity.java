package br.com.ismyburguer.pedido.adapters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "item_pedido",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_item_pedido_produto", columnNames = {"pedido_id", "produto_id"})
        }
)
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoEntity {

    @Id
    private UUID itemPedidoId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @Column(name = "produto_id")
    private UUID produtoId;

    private int quantidade;

    private BigDecimal preco;

    private BigDecimal valorTotal;

    public ItemPedidoEntity(UUID itemPedidoId, UUID produtoId, int quantidade, BigDecimal preco, BigDecimal valorTotal) {
        this.itemPedidoId = itemPedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ItemPedidoEntity that)) return false;

        return new EqualsBuilder()
                .append(getItemPedidoId(), that.getItemPedidoId())
                .append(getPedido(), that.getPedido())
                .append(getProdutoId(), that.getProdutoId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getItemPedidoId())
                .append(getPedido())
                .append(getProdutoId())
                .toHashCode();
    }
}
