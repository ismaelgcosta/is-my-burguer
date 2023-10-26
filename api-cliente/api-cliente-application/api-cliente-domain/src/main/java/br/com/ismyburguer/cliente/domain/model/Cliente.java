package br.com.ismyburguer.cliente.domain.model;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Cliente implements Validation {

    @Valid
    @Setter
    private ClienteId clienteId;

    @Valid
    private Nome nome;

    @Valid
    private Email email;

    @Valid
    private CPF cpf;

    public Cliente(Nome nome) {
        this.nome = nome;
    }

    public Cliente(Nome nome, Email email, CPF cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
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
        @Size(min = 3, message = "O nome deve conter pelo menos 3 letras")
        String nome;

        String sobrenome;
    }
    @Getter
    @AllArgsConstructor
    public static class CPF {

        @org.hibernate.validator.constraints.br.CPF
        private String numero;

    }

    @Getter
    @AllArgsConstructor
    public static class ClienteId {

        @NotNull(message = "Informe o código do Cliente")
        private UUID clienteId;

    }

    public Optional<CPF> getCpf() {
        return Optional.ofNullable(cpf);
    }


}
