package br.com.ismyburguer.pagamento.adapters.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pagamento")
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoEntity {

    @Id
    private UUID pagamentoId = UUID.randomUUID();

    @Column(name = "pedido_id", columnDefinition = "character varying(255) references pedido(pedido_id)")
    private UUID pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEntity statusPagamento;

    @Enumerated(EnumType.STRING)
    private TipoPagamentoEntity tipoPagamento;

    @Enumerated(EnumType.STRING)
    private FormaPagamentoEntity formaPagamento;

    private BigDecimal valorTotal;

    private String qrCode;

    public PagamentoEntity(UUID pedidoId, StatusPagamentoEntity statusPagamento, TipoPagamentoEntity tipoPagamento, FormaPagamentoEntity formaPagamento, BigDecimal valorTotal) {
        this.pedidoId = pedidoId;
        this.statusPagamento = statusPagamento;
        this.tipoPagamento = tipoPagamento;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PagamentoEntity that)) return false;

        return new EqualsBuilder().append(getPagamentoId(), that.getPagamentoId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPagamentoId()).toHashCode();
    }
}
