package br.com.ismyburguer.pedido.adapters.entity;

public enum StatusPedidoEntity {

    ABERTO("Aberto"),
    FECHADO("Fechado"),
    PAGO("Pago"),
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGAMENTO_NAO_AUTORIZADO("Pagamento Não Autorizado"),
    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em Preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado");

    private final String descricao;

    StatusPedidoEntity(String descricao) {
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
