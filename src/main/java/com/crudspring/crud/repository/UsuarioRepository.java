package com.crudspring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.crudspring.crud.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, String>{

	public UserDetails findByEmail(String email);
}
