package br.com.ismyburguer.cliente.adapters.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    private UUID clienteId = UUID.randomUUID();

    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;

    public ClienteEntity() {
    }

    public ClienteEntity(String nome, String sobrenome, String email, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
    }

    public Optional<String> getCpf() {
        return Optional.ofNullable(cpf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteEntity that)) return false;
        return Objects.equals(getClienteId(), that.getClienteId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClienteId());
    }
}
