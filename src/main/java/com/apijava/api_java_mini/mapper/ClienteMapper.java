package com.apijava.api_java_mini.mapper;
import org.mapstruct.Mapper;

import com.apijava.api_java_mini.dto.ClienteDTO;
import com.apijava.api_java_mini.entity.Cliente;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface ClienteMapper {
@Mapping(source = "pessoaId",target = "pessoa.id")
Cliente toEntity(ClienteDTO dto);

@Mapping(source = "pessoa.id",target = "pessoaId")
ClienteDTO toDTO(Cliente entity);

}
