package br.com.ismyburguer.produto.adapters.entity;

public enum CategoriaEntity {

    LANCHE("Lanche"),
    ACOMPANHAMENTO("Acompanhamento"),
    BEBIDA("Bebida"),
    SOBREMESA("Sobremesa");

    private final String categoria;

    CategoriaEntity(String categoria) {
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
