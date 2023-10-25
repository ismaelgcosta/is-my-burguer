package br.com.ismyburguer.produto.adapters.web.controller;


import br.com.ismyburguer.core.adapter.in.WebAdapter;
import br.com.ismyburguer.produto.adapters.web.converter.BuscarProdutoConverter;
import br.com.ismyburguer.produto.adapters.web.response.BuscarProdutoResponse;
import br.com.ismyburguer.produto.ports.in.ConsultarProdutoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Produto", description = "Gerenciamento de Produtos")
@WebAdapter
@RequestMapping("/produtos")
public class BuscarProdutoController {
    private final ConsultarProdutoUseCase consultarProdutoUseCase;
    private final BuscarProdutoConverter buscarProdutoConverter;

    public BuscarProdutoController(ConsultarProdutoUseCase consultarProdutoUseCase,
                                   BuscarProdutoConverter buscarProdutoConverter) {
        this.consultarProdutoUseCase = consultarProdutoUseCase;
        this.buscarProdutoConverter = buscarProdutoConverter;
    }

    @Operation(description = "Consultar Produto")
    @GetMapping("/{produtoId}")
    public BuscarProdutoResponse obterProduto(@PathVariable(name = "produtoId") String produtoId) {
        return buscarProdutoConverter.convert(consultarProdutoUseCase.buscar(new ConsultarProdutoUseCase.ConsultaProdutoQuery(produtoId)));
    }

}
