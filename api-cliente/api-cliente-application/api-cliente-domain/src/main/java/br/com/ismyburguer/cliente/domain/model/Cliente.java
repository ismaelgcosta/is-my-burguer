package br.com.ismyburguer.cliente.domain.model;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.metadata.facets.Validatable;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Cliente implements Validation {

    @Valid
    private Nome nome;

    @Valid
    private Email email;

    @Valid
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

        @NotBlank(message = "Informe o campo nome")
        @Min(value = 3, message = "O nome deve conter pelo menos 3 letras")
        String nome;

        String sobrenome;
    }
    @Getter
    @AllArgsConstructor
    public static class CPF {

        @org.hibernate.validator.constraints.br.CPF
        private String numero;

    }

    public Optional<CPF> getCpf() {
        return Optional.ofNullable(cpf);
    }


}
