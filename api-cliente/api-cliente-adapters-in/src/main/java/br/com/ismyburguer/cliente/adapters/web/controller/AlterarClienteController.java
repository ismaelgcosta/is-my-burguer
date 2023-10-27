package br.com.ismyburguer.cliente.adapters.web.controller;


import br.com.ismyburguer.cliente.adapters.web.converter.AlterarClienteRequestConverter;
import br.com.ismyburguer.cliente.adapters.web.request.AlterarClienteRequest;
import br.com.ismyburguer.cliente.ports.in.AlterarClienteUseCase;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cliente", description = "Gerenciamento de Clientes")
@WebAdapter
@RequestMapping("/clientes")
public class AlterarClienteController {
    private final AlterarClienteUseCase useCase;
    private final AlterarClienteRequestConverter converter;

    public AlterarClienteController(AlterarClienteUseCase useCase,
                                    AlterarClienteRequestConverter converter) {
        this.useCase = useCase;
        this.converter = converter;
    }

    @Operation(method = "Alterar Cliente", description = "Alterar Cliente")
    @PutMapping("/{clienteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarCliente(
            @PathVariable @Valid @UUID(message = "O código do cliente informado está num formato inválido") String clienteId,
            @RequestBody AlterarClienteRequest request
    ) {
        useCase.alterar(clienteId, converter.convert(request));
    }

}
