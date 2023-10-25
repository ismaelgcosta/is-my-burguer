package br.com.ismyburguer.produto.adapters.web.request;

import br.com.ismyburguer.core.validation.EnumNamePattern;
import br.com.ismyburguer.core.validation.Validation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AlterarProdutoRequest implements Validation {

    @NotBlank(message = "Informe o campo descrição")
    @Size(min = 3, message = "A descrição deve conter pelo menos 3 letras")
    private String descricao;

    @Schema(description = "Categoria do Produto",
            allowableValues = {
                    "LANCHE",
                    "ACOMPANHAMENTO",
                    "BEBIDA",
                    "SOBREMESA"
            })
    @EnumNamePattern(
            regexp = "LANCHE|ACOMPANHAMENTO|BEBIDA|SOBREMESA",
            message = "O campo categoria do produto deve ser igual a {regexp}"
    )
    private String categoria;

    private BigDecimal preco;
}
