package br.com.ismyburguer.produto.domain.model;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Produto implements Validation {

    @Valid
    @Setter
    private ProdutoId produtoId;

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

    public Produto(Descricao descricao, Categoria categoria, Preco preco) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }

    @Getter
    @AllArgsConstructor
    public static class ProdutoId {

        @NotNull(message = "Informe o código do Produto")
        private UUID produtoId;

    }

    @Getter
    @AllArgsConstructor
    public static class Descricao {

        @NotBlank(message = "Informe o campo valor da Descrição")
        @Size(min = 3, message = "A descrição deve conter pelo menos 3 letras")
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

}
