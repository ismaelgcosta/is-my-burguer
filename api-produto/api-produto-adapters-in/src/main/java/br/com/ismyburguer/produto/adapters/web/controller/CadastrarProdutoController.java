package br.com.ismyburguer.produto.adapters.web.controller;


import br.com.ismyburguer.core.adapter.in.WebAdapter;
import br.com.ismyburguer.produto.adapters.web.converter.CadastrarProdutoRequestConverter;
import br.com.ismyburguer.produto.adapters.web.request.CriarProdutoRequest;
import br.com.ismyburguer.produto.ports.in.CadastrarProdutoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Produto", description = "Gerenciamento de Produtos")
@WebAdapter
@RequestMapping("/produtos")
public class CadastrarProdutoController {
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final CadastrarProdutoRequestConverter cadastrarProdutoRequestConverter;

    public CadastrarProdutoController(CadastrarProdutoUseCase cadastrarProdutoUseCase,
                                      CadastrarProdutoRequestConverter cadastrarProdutoRequestConverter) {
        this.cadastrarProdutoUseCase = cadastrarProdutoUseCase;
        this.cadastrarProdutoRequestConverter = cadastrarProdutoRequestConverter;
    }

    @Operation(description = "Cadastrar Produto")
    @PostMapping
    public UUID cadastrarProduto(@RequestBody CriarProdutoRequest criarProdutoRequest) {
        return cadastrarProdutoUseCase.cadastrar(cadastrarProdutoRequestConverter.convert(criarProdutoRequest));
    }

}
