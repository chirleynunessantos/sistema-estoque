package com.crudspring.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspring.crud.model.Usuario;
import com.crudspring.crud.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@ Autowired
	UsuarioRepository repository;	

	public void salvarUsuaro(Usuario usuario) {
		repository.save(usuario);
	}
	
	public void alterarUsuaro(Usuario usuario) {
		repository.save(usuario);
	}
	
	public void deleteUsuaro(String usuario) {
		repository.deleteById(usuario);
	}
	
	public Optional<Usuario> buscarUsuaro(String usuario) {
		return repository.findById(usuario);
	}
}
