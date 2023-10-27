package br.com.ismyburguer.controlepedido.adapters.adapters.entity;

import lombok.Getter;

@Getter
public enum StatusControlePedidoEntity {

    AGUARDANDO_CONFIRMACAO("Aguardando Confirmação do ControlePedido"),
    NAO_AUTORIZADO("Não Autorizado"),
    PAGO("Pago");

    private final String descricao;

    StatusControlePedidoEntity(String descricao) {
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

