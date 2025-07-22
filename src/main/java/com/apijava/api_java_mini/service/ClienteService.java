package com.apijava.api_java_mini.service;
import com.apijava.api_java_mini.dto.ClienteDTO;
import com.apijava.api_java_mini.entity.Cliente;
import com.apijava.api_java_mini.entity.Pessoa;
import com.apijava.api_java_mini.mapper.ClienteMapper;
import com.apijava.api_java_mini.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }


    public Cliente salvar(ClienteDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        return clienteRepository.save(cliente);
    }

    public List<ClienteDTO> listarTodosDTO() {
        List<Cliente> clientes = clienteRepository.findAllComPessoa();
        return clientes.stream()
                .map(clienteMapper::toDTO)
                .toList();
    }










    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " não encontrado"));
    }

    public Cliente atualizar(Long id, ClienteDTO dto) {
        Cliente clienteExistente = buscarPorId(id);
        Cliente atualizado = clienteMapper.toEntity(dto);
        //preservar id e datacadastro
        atualizado.setId(clienteExistente.getId());
        atualizado.setDataCadastro(clienteExistente.getDataCadastro());
        return clienteRepository.save(atualizado);
    }
    public void deletar(Long id){
        Cliente cliente=buscarPorId(id);
        clienteRepository.delete(cliente);
    }

}

