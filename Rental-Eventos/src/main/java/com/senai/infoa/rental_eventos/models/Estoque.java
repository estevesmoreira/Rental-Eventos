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

    @Column(name = "quantidades_disponivei")
    private Integer quantidadesDisponivel;

    @Column(name = "quantidades_reservada")
    private Integer quantidadesReservada;

    @Column(name = "quantidades_minima")
    private Integer quantidadesMinima;

    @OneToMany(mappedBy = "estoque")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "estoque")
    private List<Equipamento> equipamentos;

    public Estoque() {

    }

    public Estoque(Integer quantidadesDisponivel, Integer quantidadesReservada, Integer quantidadesMinima,
            List<Endereco> enderecos, List<Equipamento> equipamentos) {
        this.quantidadesDisponivel = quantidadesDisponivel;
        this.quantidadesReservada = quantidadesReservada;
        this.quantidadesMinima = quantidadesMinima;
        this.enderecos = enderecos;
        this.equipamentos = equipamentos;
    }

    public Integer getQuantidadesDisponiveis() {
        return quantidadesDisponivel;
    }

    public void setQuantidadesDisponiveis(Integer quantidadesDisponivel) {
        this.quantidadesDisponivel = quantidadesDisponivel;
    }

    public Integer getQuantidadesReservadas() {
        return quantidadesReservada;
    }

    public void setQuantidadesReservadas(Integer quantidadesReservada) {
        this.quantidadesReservada = quantidadesReservada;
    }

    public Integer getQuantidadesMinimas() {
        return quantidadesMinima;
    }

    public void setQuantidadesMinimas(Integer quantidadesMinima) {
        this.quantidadesMinima = quantidadesMinima;
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
