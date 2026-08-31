package com.senai.infoa.rental_eventos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Estoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "quantidades_disponiveis")
    private Integer quantidadesDisponiveis;

    @Column(name = "quantidades_reservadas")
    private Integer quantidadesReservadas;

    @Column(name = "quantidade_locacoes")
    private Integer quantidadeLocacoes;

    @OneToMany(mappedBy = "estoque")
    private List<Endereco> enderecos;

    public Estoque() {
    }

    public Estoque(Integer quantidadesDisponiveis, Integer quantidadesReservadas, Integer quantidadeLocacoes) {
        this.quantidadesDisponiveis = quantidadesDisponiveis;
        this.quantidadesReservadas = quantidadesReservadas;
        this.quantidadeLocacoes = quantidadeLocacoes;
    }

    public Integer getQuantidadesDisponiveis() {
        return quantidadesDisponiveis;
    }

    public void setQuantidadesDisponiveis(Integer quantidadesDisponiveis) {
        this.quantidadesDisponiveis = quantidadesDisponiveis;
    }

    public Integer getQuantidadesReservadas() {
        return quantidadesReservadas;
    }

    public void setQuantidadesReservadas(Integer quantidadesReservadas) {
        this.quantidadesReservadas = quantidadesReservadas;
    }

    public Integer getQuantidadeLocacoes() {
        return quantidadeLocacoes;
    }

    public void setQuantidadeLocacoes(Integer quantidadeLocacoes) {
        this.quantidadeLocacoes = quantidadeLocacoes;
    }

    
}
