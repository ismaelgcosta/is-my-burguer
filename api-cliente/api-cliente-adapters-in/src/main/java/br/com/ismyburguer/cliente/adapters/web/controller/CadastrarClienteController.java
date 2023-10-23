package br.com.ismyburguer.cliente.adapters.web.controller;

import br.com.ismyburguer.cliente.adapters.web.converter.CadastrarClienteRequestConverter;
import br.com.ismyburguer.cliente.adapters.web.request.CriarClienteRequest;
import br.com.ismyburguer.cliente.ports.in.CadastrarClienteUseCase;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@WebAdapter
@RequestMapping("/clientes")
public class CadastrarClienteController {
    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final CadastrarClienteRequestConverter cadastrarClienteRequestConverter;

    public CadastrarClienteController(CadastrarClienteUseCase cadastrarClienteUseCase,
                                      CadastrarClienteRequestConverter cadastrarClienteRequestConverter) {
        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.cadastrarClienteRequestConverter = cadastrarClienteRequestConverter;
    }

    @PostMapping
    public UUID cadastrarCliente(@RequestBody CriarClienteRequest criarClienteRequest) {
        return cadastrarClienteUseCase.cadastrar(cadastrarClienteRequestConverter.convert(criarClienteRequest));
    }

}
