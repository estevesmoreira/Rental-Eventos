package com.senai.infoa.rental_eventos.models;

import com.senai.infoa.rental_eventos.enuns.CategoriaEquipamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Integer preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_equipamento")
    private CategoriaEquipamento categoria;

    @Column(name = "peso")
    private Float peso;

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    public Equipamento() {
    }

    public Equipamento(String nome, Integer preco, CategoriaEquipamento categoria, Float peso) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public CategoriaEquipamento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEquipamento categoria) {
        this.categoria = categoria;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

}
