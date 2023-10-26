package br.com.ismyburguer.pagamento.adapters.entity;

import lombok.Getter;

@Getter
public enum StatusPagamentoEntity {

    AGUARDANDO_CONFIRMACAO("Aguardando Confirmação do Pagamento"),
    NAO_AUTORIZADO("Não Autorizado"),
    PAGO("Pago");

    private final String descricao;

    StatusPagamentoEntity(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}

