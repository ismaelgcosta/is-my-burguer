package br.com.ismyburguer.controlepedido.adapters.adapters.entity;

import lombok.Getter;

@Getter
public enum StatusControlePedidoEntity {

    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em Preparação"),
    PRONTO("Pronto"),
    RETIRADO("Retirado");

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

