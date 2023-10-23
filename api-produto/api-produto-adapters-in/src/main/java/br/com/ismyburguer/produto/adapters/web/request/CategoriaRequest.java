package br.com.ismyburguer.produto.adapters.web.request;

public enum CategoriaRequest {

    LANCHE("Lanche"),
    ACOMPANHAMENTO("Acompanhamento"),
    BEBIDA("Bebida"),
    SOBREMESA("Sobremesa");

    private final String categoria;

    CategoriaRequest(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return categoria;
    }
}