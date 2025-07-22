package com.apijava.api_java_mini.entity;


import jakarta.persistence.*;


@Table(name="produto")
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long Id;
    private String nome;
    private  String descricaoproduto;
    private Double	preco_unitario;
    private int  quantidade;
    private  String categoria;
    private boolean ativo;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public Double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(Double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Produto() {
    }

    public Produto(String nome, String descricaoproduto, Double preco_unitario, int quantidade, String categoria, boolean ativo) {
        this.nome = nome;
        this.descricaoproduto = descricaoproduto;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.ativo = ativo;
    }
}
