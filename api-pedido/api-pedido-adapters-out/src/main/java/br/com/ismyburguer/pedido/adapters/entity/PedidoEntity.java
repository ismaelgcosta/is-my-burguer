package br.com.ismyburguer.pedido.adapters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pedido")
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {

    @Id
    private UUID pedidoId = UUID.randomUUID();

    @Column(name = "cliente_id", columnDefinition = "character varying(255) references cliente(cliente_id)")
    private UUID clienteId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Set<ItemPedidoEntity> itens;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEntity statusPedido = StatusPedidoEntity.ABERTO;

    private BigDecimal valorTotal;

    public PedidoEntity(UUID pedidoId, UUID clienteId, StatusPedidoEntity statusPedido, BigDecimal valorTotal) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PedidoEntity that)) return false;

        return new EqualsBuilder().append(getPedidoId(), that.getPedidoId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPedidoId()).toHashCode();
    }

    public void addItem(ItemPedidoEntity item) {
        itens = itens == null ? new HashSet<>() : itens;
        itens.forEach(itemPedidoEntity -> itemPedidoEntity.setPedido(this));
    }
}
