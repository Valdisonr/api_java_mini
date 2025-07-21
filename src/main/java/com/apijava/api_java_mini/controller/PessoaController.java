package com.apijava.api_java_mini.controller;


import com.apijava.api_java_mini.dto.PessoaDTO;
import com.apijava.api_java_mini.entity.Pessoa;
import com.apijava.api_java_mini.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

@GetMapping
    public List<Pessoa> Listar(){
        return pessoaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        try {
            Pessoa pessoa = pessoaService.buscarPorId(id);
            return ResponseEntity.ok(pessoa);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


@PostMapping
public Pessoa criar(@Valid @RequestBody PessoaDTO pessoadto){
        return pessoaService.criar(pessoadto);
}
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody PessoaDTO pessoaDto) {
        try {
            Pessoa atualizada = pessoaService.atualizar(id, pessoaDto);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

