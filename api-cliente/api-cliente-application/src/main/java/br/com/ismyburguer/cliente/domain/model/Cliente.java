package br.com.ismyburguer.cliente.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Cliente {
    private Nome nome;
    private Email email;
    private CPF cpf;
    public Cliente(Nome nome) {
        this.nome = nome;
    }

    @Getter
    @AllArgsConstructor
    public static class Email {
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
