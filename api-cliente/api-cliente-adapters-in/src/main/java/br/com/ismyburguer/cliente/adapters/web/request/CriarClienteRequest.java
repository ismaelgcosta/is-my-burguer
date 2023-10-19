package br.com.ismyburguer.cliente.adapters.web.request;

import br.com.ismyburguer.cliente.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CriarClienteRequest {

    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    public Optional<String> getCpf() {
        return Optional.ofNullable(cpf);
    }

}
