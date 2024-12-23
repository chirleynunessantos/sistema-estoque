package com.crudspring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspring.crud.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, String>{

}
