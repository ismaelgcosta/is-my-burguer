package br.com.ismyburguer.produto.domain.model;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class Produto implements Validation {

    @Valid
    @NotNull(message = "Informe a descrição do produto")
    private Descricao descricao;

    @Valid
    @NotNull(message = "Informe a categoria do produto")
    private Categoria categoria;

    @Valid
    @NotNull(message = "Informe o preço do produto")
    private Produto.Preco preco;
    public Produto(Categoria categoria) {
        this.categoria = categoria;
    }

    @Getter
    @AllArgsConstructor
    public static class Descricao {

        @NotBlank(message = "Informe o campo valor da Descrição")
        @Min(value = 3, message = "A descrição deve conter pelo menos 3 letras")
        String valor;
    }

    @Getter
    public enum Categoria {

        LANCHE("Lanche"),
        ACOMPANHAMENTO("Acompanhamento"),
        BEBIDA("Bebida"),
        SOBREMESA("Sobremesa");

        private final String descricao;

        Categoria(String descricao) {
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
    public static class Preco {

        @NotNull(message = "Informe o preço do produto")
        @DecimalMin(value = "0.01", message = "O preço do produto deve ser de no mínimo R$0,01")
        private BigDecimal valor;

    }

    public Preco getPreco() {
        return preco;
    }


}
