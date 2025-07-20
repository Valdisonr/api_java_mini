package com.apijava.api_java_mini.controller;


import com.apijava.api_java_mini.entity.Pessoa;
import com.apijava.api_java_mini.service.PessoaService;
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
public Pessoa criar(@RequestBody Pessoa pessoa){
        return pessoaService.criar(pessoa);
}

@PutMapping
public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {
    try {
        Pessoa atualizada = pessoaService.atualizar(pessoa.getId(), pessoa);
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

