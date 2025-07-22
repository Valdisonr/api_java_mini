package com.apijava.api_java_mini.dto;

import jakarta.validation.constraints.*;

public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    @Size(max = 255, message = "Nome deve ter no máximo 255 caracteres.")
    private String nome;

    @NotBlank(message = "Descrição do produto é obrigatória.")
    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres.")
    private String descricaoProduto;

    @NotNull(message = "Preço unitário é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço deve ser maior que zero.")
    private Double precoUnitario;

    @Min(value = 0, message = "Quantidade não pode ser negativa.")
    private int quantidade;

    @NotBlank(message = "Categoria é obrigatória.")
    @Size(max = 100, message = "Categoria deve ter no máximo 100 caracteres.")
    private String categoria;

    private boolean ativo;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricaoProduto() { return descricaoProduto; }
    public void setDescricaoProduto(String descricaoProduto) { this.descricaoProduto = descricaoProduto; }

    public Double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(Double precoUnitario) { this.precoUnitario = precoUnitario; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
