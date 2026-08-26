package com.senai.infoa.rental_eventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.senai.infoa.rental_eventos.models.Endereco;
import com.senai.infoa.rental_eventos.models.Locacao;

@Entity
public class Locatario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private Integer telefone;

    @Column(name = "cpf")
    private Integer cpf;

    @OneToMany
    @JoinColumn(name = "locatario_id")
    private List<Locacao> locacao;

    @OneToMany
    @JoinColumn(name = "locatario_id")
    private List<Endereco> endereco;

    public Locatario() {
    }

    public Locatario(String nome, String email, Integer telefone, Integer cpf, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }


}
