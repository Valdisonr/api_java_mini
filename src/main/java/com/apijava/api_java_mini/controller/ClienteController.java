package com.apijava.api_java_mini.controller;

import com.apijava.api_java_mini.dto.ClienteDTO;
import com.apijava.api_java_mini.entity.Cliente;
import com.apijava.api_java_mini.mapper.ClienteMapper;
import com.apijava.api_java_mini.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;
    private  final ClienteMapper clienteMapper;
    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }
    @PostMapping
    public ResponseEntity<ClienteDTO>criar(@Valid @RequestBody ClienteDTO dto){
        Cliente clienteSalvo=clienteService.salvar(dto);
        ClienteDTO dtoSalvo=clienteMapper.toDTO(clienteSalvo);
        return ResponseEntity.ok(dtoSalvo);
    }
@GetMapping
    public ResponseEntity<List<ClienteDTO>>ListarTodos(){
List<ClienteDTO>clientes=clienteService.listarTodos()
        .stream()
        .map(clienteMapper::toDTO)
        .collect(Collectors.toList());
return  ResponseEntity.ok(clientes);
    }

@GetMapping("/{id}")
    public ResponseEntity<ClienteDTO>buscarPorId(@PathVariable Long id){
        Cliente cliente=clienteService.buscarPorId(id);
        return ResponseEntity.ok(clienteMapper.toDTO(cliente));
}
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO>atualizar(@PathVariable Long id,@Valid @RequestBody ClienteDTO dto ) {
    Cliente atualizado = clienteService.atualizar(id, dto);
    return ResponseEntity.ok(clienteMapper.toDTO(atualizado));
 }

 @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
 }

 }