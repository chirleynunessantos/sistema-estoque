package com.crudspring.crud.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspring.crud.model.Usuario;
import com.crudspring.crud.service.UsuarioService;
@RequestMapping("/usuario")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@PostMapping
	public ResponseEntity salvarUsuario(@RequestBody Usuario usuario){
		System.out.println("entrou");
		LocalDate dataNascimento = usuario.getNascimento();
		usuario.setNascimento(dataNascimento);
		service.salvarUsuaro(usuario);
		
		return ResponseEntity.ok("Usuario salvo com sucesso");
	}
	
	@PutMapping
	public ResponseEntity alterarUsuario(@RequestBody Usuario usuario) {
		
		System.out.println("entrou");
		LocalDate dataNascimento = usuario.getNascimento();
		usuario.setNascimento(dataNascimento);
		service.alterarUsuaro(usuario);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity buscarUsuario(@PathVariable("cpf") String cpf) {
		
		Optional<Usuario> usuario = service.buscarUsuaro(cpf);
		
		return ResponseEntity.ok(usuario);
		
	}
	@DeleteMapping("/{cpf}")
	public ResponseEntity deletaUsuario(@PathVariable ("cpf") String cpf) {
		service.deleteUsuaro(cpf);
		return ResponseEntity.ok().build();
	}
	
	
	}
