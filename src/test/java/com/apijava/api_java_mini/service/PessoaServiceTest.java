package com.apijava.api_java_mini.service;

import com.apijava.api_java_mini.entity.Pessoa;
import com.apijava.api_java_mini.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PessoaServiceIntegrationTest {

    @Autowired
    private PessoaService pessoaService;

//    @Test
//    void deveSalvarEPesquisarPessoa() {
//        Pessoa pessoa = new Pessoa("Maria", "000.111.222-33", "25", "maria@email.com", "12345-6789");
//        Pessoa salva = pessoaService.criar(pessoa);
//
//        Pessoa encontrada = pessoaService.buscarPorId(salva.getId());
//
//        assertEquals("Maria", encontrada.getNome());
//        assertEquals("000.111.222-33", encontrada.getCpf());
//    }
}
