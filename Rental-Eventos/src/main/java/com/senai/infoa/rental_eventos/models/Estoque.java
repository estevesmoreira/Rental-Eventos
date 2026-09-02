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

    @Column(name = "quantidades_locacoes")
    private Integer quantidadesLocacoes;

    @OneToMany(mappedBy = "estoque")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "estoque")
    private List<Equipamento> equipamentos;

    public Estoque() {

    }

    public Estoque(Integer quantidadesDisponiveis, Integer quantidadesReservadas, Integer quantidadesLocacoes, List<Endereco> enderecos, List<Equipamento> equipamentos) {
        this.quantidadesDisponiveis = quantidadesDisponiveis;
        this.quantidadesReservadas = quantidadesReservadas;
        this.quantidadesLocacoes = quantidadesLocacoes;
        this.enderecos = enderecos;
        this.equipamentos = equipamentos;
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

    public Integer getQuantidadesLocacoes() {
        return quantidadesLocacoes;
    }

    public void setQuantidadesLocacoes(Integer quantidadesLocacoes) {
        this.quantidadesLocacoes = quantidadesLocacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

}
