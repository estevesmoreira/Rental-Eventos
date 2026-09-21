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
import jakarta.persistence.OneToOne;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Integer preco;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "potencia")
    private String potencia;

    @Column(name = "material")
    private String material;

    @Column(name = "dimensoes")
    private String dimensoes;

    @Column(name = "cor")
    private String cor;

    @Column(name = "peso")
    private Float peso;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_equipamento")
    private CategoriaEquipamento categoria;

    @OneToOne
    @JoinColumn(name = "estoque_id", unique = true)
    private Estoque estoque;

    public Equipamento() {
    }

    public Equipamento(String nome, Integer preco, CategoriaEquipamento categoria, Float peso, Estoque estoque, String marca, String modelo, String potencia, String material, String dimensoes, String cor) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.peso = peso;
        this.estoque = estoque;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.material = material;
        this.dimensoes = dimensoes;
        this.cor = cor;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
