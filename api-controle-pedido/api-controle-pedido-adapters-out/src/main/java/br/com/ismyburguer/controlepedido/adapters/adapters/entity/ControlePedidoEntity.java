package br.com.ismyburguer.controlepedido.adapters.adapters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "controle_pedido")
@AllArgsConstructor
@NoArgsConstructor
public class ControlePedidoEntity {

    @Id
    private UUID controlePedidoId = UUID.randomUUID();

    @Column(name = "pedido_id", columnDefinition = "uuid references pedido(pedido_id)")
    private UUID pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusControlePedidoEntity statusControlePedido;

    private LocalDateTime recebidoEm = LocalDateTime.now();

    @Setter
    private LocalDateTime inicioDaPreparacao;

    @Setter
    private LocalDateTime fimDaPreparacao;

    public ControlePedidoEntity(UUID pedidoId, StatusControlePedidoEntity statusControlePedido, LocalDateTime recebidoEm) {
        this.pedidoId = pedidoId;
        this.statusControlePedido = statusControlePedido;
        this.recebidoEm = recebidoEm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ControlePedidoEntity that)) return false;

        return new EqualsBuilder().append(getControlePedidoId(), that.getControlePedidoId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getControlePedidoId()).toHashCode();
    }
}
