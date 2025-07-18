package com.apijava.api_java_mini.service;
import com.apijava.api_java_mini.entity.Pessoa;
import com.apijava.api_java_mini.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;


    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }



        public List<Pessoa> listarTodas() {
            return pessoaRepository.findAll();
        }

        public Optional<Pessoa> buscarPorId(Long id) {
            return pessoaRepository.findById(id);
        }

        public Pessoa criar(Pessoa pessoa) {
            return pessoaRepository.save(pessoa);
        }

        public Pessoa atualizar(Long id, Pessoa novaPessoa) {
            return pessoaRepository.findById(id)
                    .map(pessoa -> {
                        pessoa.setNome(novaPessoa.getNome());
                        pessoa.setCpf(novaPessoa.getCpf());
                        pessoa.setEmail(novaPessoa.getEmail());
                        return pessoaRepository.save(pessoa);
                    })
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID " + id));
        }

        public void deletar(Long id) {
            pessoaRepository.deleteById(id);
        }
    }



