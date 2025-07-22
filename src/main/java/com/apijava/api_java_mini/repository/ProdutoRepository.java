package com.apijava.api_java_mini.repository;

import com.apijava.api_java_mini.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {


}
