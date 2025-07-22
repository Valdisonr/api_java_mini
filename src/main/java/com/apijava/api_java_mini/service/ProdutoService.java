package com.apijava.api_java_mini.service;

import com.apijava.api_java_mini.dto.ProdutoDTO;
import com.apijava.api_java_mini.entity.Produto;
import com.apijava.api_java_mini.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }



    // Converter Produto para ProdutoDTO
    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricaoProduto(produto.getDescricaoproduto());
        dto.setPrecoUnitario(produto.getPreco_unitario());
        dto.setQuantidade(produto.getQuantidade());
        dto.setCategoria(produto.getCategoria());
        dto.setAtivo(produto.isAtivo());
        return dto;
    }

    // Converter ProdutoDTO para Produto
    private Produto toEntity(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricaoproduto(dto.getDescricaoProduto());
        produto.setPreco_unitario(dto.getPrecoUnitario());
        produto.setQuantidade(dto.getQuantidade());
        produto.setCategoria(dto.getCategoria());
        produto.setAtivo(dto.isAtivo());
        return produto;
    }


    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toDTO(produto);
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        Produto produto = toEntity(dto);
        produto = produtoRepository.save(produto);
        return toDTO(produto);
    }

    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoExistente.setNome(dto.getNome());
        produtoExistente.setDescricaoproduto(dto.getDescricaoProduto());
        produtoExistente.setPreco_unitario(dto.getPrecoUnitario());
        produtoExistente.setQuantidade(dto.getQuantidade());
        produtoExistente.setCategoria(dto.getCategoria());
        produtoExistente.setAtivo(dto.isAtivo());

        produtoExistente = produtoRepository.save(produtoExistente);
        return toDTO(produtoExistente);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

}
