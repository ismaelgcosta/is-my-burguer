package br.com.ismyburguer.cliente.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.UniqueConstraint;
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
