package com.apijava.api_java_mini.service;
import com.apijava.api_java_mini.dto.PessoaDTO;
import com.apijava.api_java_mini.entity.Pessoa;
import com.apijava.api_java_mini.repository.PessoaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;


    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }



        public List<Pessoa> listarTodas() {
            return pessoaRepository.findAll();
        }



            public Pessoa buscarPorId(Long id) {
                return pessoaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + id));
            }



        public Pessoa criar(PessoaDTO dto) {
          Pessoa pessoa=new Pessoa();
          pessoa.setNome(dto.getNome());
          pessoa.setCpf(dto.getCpf());
          pessoa.setIdade(dto.getCpf());
          pessoa.setEmail(dto.getEmail());
          pessoa.setTelefone(dto.getTelefone());
           return pessoaRepository.save(pessoa);
        }

        public Pessoa atualizar(Long id, PessoaDTO dto) {
            return pessoaRepository.findById(id)
                    .map(pessoa -> {
                        pessoa.setNome(dto.getNome());
                        pessoa.setCpf(dto.getCpf());
                        pessoa.setIdade(dto.getIdade());
                        pessoa.setEmail(dto.getEmail());
                        pessoa.setTelefone(dto.getTelefone());
                        return pessoaRepository.save(pessoa);
                    })
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID " + id));
        }

        public void deletar(Long id) {
            pessoaRepository.deleteById(id);
        }
    }



