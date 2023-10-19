package br.com.ismyburguer.cliente.domain.model;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import org.hibernate.validator.internal.metadata.facets.Validatable;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Cliente implements Validation {

    private Nome nome;

    @Valid
    private Email email;
    private CPF cpf;
    public Cliente(Nome nome) {
        this.nome = nome;
    }

    @Getter
    @AllArgsConstructor
    public static class Email {

        @jakarta.validation.constraints.Email(message = "Informe um e-mail válido")
        String endereco;
    }

    @Getter
    @AllArgsConstructor
    public static class Nome {
        String nome;
        String sobrenome;
    }
    @Getter
    @AllArgsConstructor
    public static class CPF {
        private String numero;
    }

    public Optional<CPF> getCpf() {
        return Optional.ofNullable(cpf);
    }


}
