package br.com.ismyburguer.produto.adapters.web.controller;


import br.com.ismyburguer.core.adapter.in.WebAdapter;
import br.com.ismyburguer.produto.adapters.web.converter.AlterarProdutoRequestConverter;
import br.com.ismyburguer.produto.adapters.web.request.AlterarProdutoRequest;
import br.com.ismyburguer.produto.ports.in.AlterarProdutoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Produto", description = "Gerenciamento de Produtos")
@WebAdapter
@RequestMapping("/produtos")
public class AlterarProdutoController {
    private final AlterarProdutoUseCase useCase;
    private final AlterarProdutoRequestConverter converter;

    public AlterarProdutoController(AlterarProdutoUseCase useCase,
                                    AlterarProdutoRequestConverter converter) {
        this.useCase = useCase;
        this.converter = converter;
    }

    @Operation(description = "Alterar Produto")
    @PutMapping("/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarProduto(
            @PathVariable @Valid @UUID(message = "O código do produto informado está num formato inválido")String produtoId,
            @RequestBody AlterarProdutoRequest request
    ) {
        useCase.alterar(produtoId, converter.convert(request));
    }

}
