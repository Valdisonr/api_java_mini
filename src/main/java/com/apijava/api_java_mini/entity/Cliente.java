package com.apijava.api_java_mini.entity;


import jakarta.persistence.*;

import java.security.PrivilegedAction;


@Table(name="cliente")
@Entity
public class Cliente {
    public Cliente(String tipocliente) {
        this.tipocliente = tipocliente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private Long Id;
     private  String tipocliente;

     private  String endereco;
     private  String cep;

    public Cliente(String endereco, String cep) {
        this.endereco = endereco;
        this.cep = cep;
    }

    public Cliente() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(String tipocliente) {
        this.tipocliente = tipocliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
