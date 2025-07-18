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
    public ResponseEntity<Pessoa>buscarPorId(@PathVariable Long id)
{
    return pessoaService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PostMapping
public Pessoa criar(@RequestBody Pessoa pessoa){
        return pessoaService.criar(pessoa);
}

@PutMapping("/{id}")
    public ResponseEntity<Pessoa>atualizar(@PathVariable Long id , @RequestBody Pessoa pessoa)
{
    try {
        Pessoa atualizada = pessoaService.atualizar(id, pessoa);
        return ResponseEntity.ok(atualizada);
    }catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

