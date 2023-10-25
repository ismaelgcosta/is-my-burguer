package br.com.ismyburguer.produto.adapters.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    private UUID produtoId = UUID.randomUUID();

    @NotBlank(message = "Informe a descrição do produto")
    @Size(min = 3, message = "A descrição deve conter pelo menos 3 letras")
    private String descricao;

    @NotNull(message = "Informe a categoria do produto")
    @Enumerated(STRING)
    private CategoriaEntity categoria;

    @NotNull(message = "Informe o preço do produto")
    @DecimalMin(value = "0.01", message = "O preço do produto deve ser de no mínimo R$0,01")
    private BigDecimal preco;

    private boolean ativo = true;

    public ProdutoEntity() {
    }

    public ProdutoEntity(String descricao, CategoriaEntity categoria, BigDecimal preco) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ProdutoEntity that)) return false;

        return new org.apache.commons.lang3.builder.EqualsBuilder().append(getProdutoId(), that.getProdutoId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getProdutoId()).toHashCode();
    }
}
