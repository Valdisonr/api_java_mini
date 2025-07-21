package com.apijava.api_java_mini.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.security.PrivilegedAction;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY) // ou EAGER
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;



    private String endereco;

    private String numero;
    private String complemento;
    private String bairro;


    private String cidade;

    private String estado;


    private String cep;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    private Boolean ativo = true;

    public Cliente() {
    }

    public Cliente(Pessoa pessoa, String endereco, String numero, String complemento, String bairro, String cidade, String estado, String cep, LocalDateTime dataCadastro, Boolean ativo) {
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

    // Getters e Setters (ou use Lombok)


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

//    //equals e hashcode
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cliente cliente = (Cliente) o;
//        return id != null && id.equals(cliente.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
}


