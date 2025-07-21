package com.apijava.api_java_mini.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    private Long id;

    @NotBlank(message = "Endereço é obrigatório.")
    @Size(max = 255, message = "Endereço deve ter no máximo 255 caracteres.")
    private String endereco;

    @Size(max = 10, message = "Número deve ter no máximo 10 caracteres.")
    private String numero;

    @Size(max = 100, message = "Complemento deve ter no máximo 100 caracteres.")
    private String complemento;

    @Size(max = 100, message = "Bairro deve ter no máximo 100 caracteres.")
    private String bairro;

    @NotBlank(message = "Cidade é obrigatória.")
    @Size(max = 100, message = "Cidade deve ter no máximo 100 caracteres.")
    private String cidade;

    @NotBlank(message = "Estado é obrigatório.")
    @Size(max = 2, message = "Estado deve ter exatamente 2 letras.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Estado deve conter apenas letras maiúsculas (ex: SP, RJ).")
    private String estado;

    @NotBlank(message = "CEP é obrigatório.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido. Use o formato 00000-000.")
    private String cep;

    private Boolean ativo = true;

    private Long pessoaId;

    public ClienteDTO() {}

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
