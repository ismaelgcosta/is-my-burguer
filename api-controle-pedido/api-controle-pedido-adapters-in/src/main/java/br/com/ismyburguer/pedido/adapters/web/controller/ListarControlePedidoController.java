package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.controlepedido.ports.in.ListarControlePedidoUseCase;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import br.com.ismyburguer.pedido.adapters.web.converter.ListarControlePedidoConverter;
import br.com.ismyburguer.pedido.adapters.web.response.ListarControlePedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Controle de Pedidos", description = "Controle de Pedidos")
@WebAdapter
@RequestMapping("/controle-pedidos")
public class ListarControlePedidoController {
    private final ListarControlePedidoUseCase listarControlePedidoUseCase;
    private final ListarControlePedidoConverter listarControlePedidoConverter;

    public ListarControlePedidoController(ListarControlePedidoUseCase listarControlePedidoUseCase,
                                          ListarControlePedidoConverter listarControlePedidoConverter) {
        this.listarControlePedidoUseCase = listarControlePedidoUseCase;
        this.listarControlePedidoConverter = listarControlePedidoConverter;
    }

    @Operation(description = "Listar Pedidos Recebidos/Em Preparação/Prontos")
    @GetMapping
    public List<ListarControlePedidoResponse> listar() {
        return listarControlePedidoUseCase.listar().stream().map(listarControlePedidoConverter::convert).toList();
    }

}
