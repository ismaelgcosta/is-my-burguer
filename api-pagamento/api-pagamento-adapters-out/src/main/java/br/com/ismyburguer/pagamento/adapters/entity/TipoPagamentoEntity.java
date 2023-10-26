package br.com.ismyburguer.pagamento.adapters.entity;

import lombok.Getter;

@Getter
public enum TipoPagamentoEntity {

    QR_CODE("QR Code");

    private final String descricao;

    TipoPagamentoEntity(String descricao) {
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
