package br.com.ismyburguer.cliente.adapters.web.request;

import br.com.ismyburguer.core.validation.Validation;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AlterarClienteRequest implements Validation {

    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    public Optional<String> getCpf() {
        return Optional.ofNullable(cpf);
    }

}
