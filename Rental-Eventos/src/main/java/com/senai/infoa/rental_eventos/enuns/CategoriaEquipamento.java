package com.senai.infoa.rental_eventos.enuns;

public enum CategoriaEquipamento {

    SONORO("Sonoro"),
    OPTICO("Óptico"),
    MOBILIARIO("óvel"),
    DECORACAO("Decoração"),
    OUTRO("Outro");
    

    private String nomeAmigavel;

    CategoriaEquipamento(String nomeAmigavel) {
        this.nomeAmigavel = nomeAmigavel;
    }
    
    public String getNomeAmigavel() {
        return nomeAmigavel;
    }
}
