package br.com.ismyburguer.pedido.adapters.web.controller;


import br.com.ismyburguer.pedido.adapters.web.converter.CadastrarPedidoRequestConverter;
import br.com.ismyburguer.pedido.adapters.web.request.CadastrarPedidoRequest;
import br.com.ismyburguer.pedido.ports.in.CadastrarPedidoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Pedido", description = "Gerenciamento de Pedidos")
@RestController
@RequestMapping("/pedidos")
public class CadastrarPedidoController {
    private final CadastrarPedidoUseCase cadastrarPedidoUseCase;
    private final CadastrarPedidoRequestConverter cadastrarPedidoRequestConverter;

    public CadastrarPedidoController(CadastrarPedidoUseCase cadastrarPedidoUseCase,
                                      CadastrarPedidoRequestConverter cadastrarPedidoRequestConverter) {
        this.cadastrarPedidoUseCase = cadastrarPedidoUseCase;
        this.cadastrarPedidoRequestConverter = cadastrarPedidoRequestConverter;
    }

    @Operation(description = "Cadastrar Pedido")
    @PostMapping
    public UUID cadastrarPedido(@RequestBody CadastrarPedidoRequest cadastrarPedidoRequest) {
        return cadastrarPedidoUseCase.cadastrar(cadastrarPedidoRequestConverter.convert(cadastrarPedidoRequest));
    }

}
