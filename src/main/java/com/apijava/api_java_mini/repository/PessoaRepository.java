package com.apijava.api_java_mini.repository;

import com.apijava.api_java_mini.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
