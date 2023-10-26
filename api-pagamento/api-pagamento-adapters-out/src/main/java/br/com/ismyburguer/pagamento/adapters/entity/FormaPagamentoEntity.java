package br.com.ismyburguer.pagamento.adapters.entity;

import lombok.Getter;

@Getter
public enum FormaPagamentoEntity {

    MERCADO_PAGO("Mercado Pago");

    private final String descricao;

    FormaPagamentoEntity(String descricao) {
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