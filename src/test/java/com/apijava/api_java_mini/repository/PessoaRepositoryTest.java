package com.apijava.api_java_mini.repository;

import com.apijava.api_java_mini.entity.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    void deveSalvarEPesquisarPessoa() {
        Pessoa pessoa = new Pessoa("João", "123.456.789-00", "30", "joao@email.com", "9999-8888");
        Pessoa salva = pessoaRepository.save(pessoa);

        Optional<Pessoa> encontrada = pessoaRepository.findById(salva.getId());

        assertTrue(encontrada.isPresent());
        assertEquals("João", encontrada.get().getNome());
    }
}
