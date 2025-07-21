package com.apijava.api_java_mini.repository;

import com.apijava.api_java_mini.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
