package com.apijava.api_java_mini.repository;

import com.apijava.api_java_mini.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Query("SELECT c FROM Cliente c JOIN FETCH c.pessoa")
    List<Cliente> findAllComPessoa();
}
