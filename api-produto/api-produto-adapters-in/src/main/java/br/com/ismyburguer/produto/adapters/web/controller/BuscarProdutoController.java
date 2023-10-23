package br.com.ismyburguer.produto.adapters.web.controller;


import br.com.ismyburguer.produto.adapters.web.converter.BuscarProdutoConverter;
import br.com.ismyburguer.produto.adapters.web.response.BuscarProdutoResponse;
import br.com.ismyburguer.produto.ports.in.BuscarProdutoUseCase;
import br.com.ismyburguer.produto.ports.in.ConsultaProduto;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@WebAdapter
@RequestMapping("/produtos")
public class BuscarProdutoController {
    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final BuscarProdutoConverter buscarProdutoConverter;

    public BuscarProdutoController(BuscarProdutoUseCase buscarProdutoUseCase,
                                   BuscarProdutoConverter buscarProdutoConverter) {
        this.buscarProdutoUseCase = buscarProdutoUseCase;
        this.buscarProdutoConverter = buscarProdutoConverter;
    }

    @GetMapping("/{produtoId}")
    public BuscarProdutoResponse obterProduto(@PathVariable(name = "produtoId") String produtoId) {
        return buscarProdutoConverter.convert(buscarProdutoUseCase.buscar(new ConsultaProduto(produtoId)));
    }

}
