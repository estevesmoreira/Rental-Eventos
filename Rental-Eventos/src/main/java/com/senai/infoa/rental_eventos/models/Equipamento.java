package com.senai.infoa.rental_eventos.models;

import com.senai.infoa.rental_eventos.enuns.CategoriaEquipamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "preco")
    private Integer preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_equipamento")
    private CategoriaEquipamento categoria;

    @Column(name = "peso")
    private Integer peso;

    public Equipamento() {
    }

    public Equipamento(Long id, String nomeProduto, Integer preco, CategoriaEquipamento categoria, Integer peso) {
        this.id = id;
        this.nomeProduto = nomeProduto;
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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
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

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    
}
