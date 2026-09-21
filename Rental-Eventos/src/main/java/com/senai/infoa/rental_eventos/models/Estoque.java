package com.senai.infoa.rental_eventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer quantidadeDisponivel = 0;

    @Column(name = "quantidade_reservada")
    private Integer quantidadeReservada;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer quantidadeMinima = 0;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Estoque() {

    }

    public Estoque(Integer quantidadeDisponivel, Integer quantidadeReservada, Integer quantidadeMinima) {
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeReservada = quantidadeReservada;
        this.quantidadeMinima = quantidadeMinima;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getQuantidadeReservada() {
        return quantidadeReservada;
    }

    public void setQuantidadeReservada(Integer quantidadeReservada) {
        this.quantidadeReservada = quantidadeReservada;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
