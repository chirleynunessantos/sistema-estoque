package com.crudspring.crud.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspring.crud.model.ResgistroDTO;
import com.crudspring.crud.model.Usuario;
import com.crudspring.crud.repository.UsuarioRepository;
import com.crudspring.crud.service.UsuarioService;
@RequestMapping("/usuario")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;
//	@Autowired
//	EnderecoService enderecoService;
	@Autowired
	UsuarioRepository repository;
	/*
	@PostMapping
	public ResponseEntity salvarUsuario(@RequestBody ResgistroDTO usuario){
		
		if(repository.findByEmail(usuario.login()) != null ) {
			ResponseEntity.badRequest();
		}else {
		
			String encriptografando = new  BCryptPasswordEncoder().encode(usuario.senha());
			
			//LocalDate dataNascimento = usuario.getNascimento();
			//usuario.setNascimento(dataNascimento);
			//service.salvarUsuaro(usuario);
			
			//CepResultDTOP endereco =  apiCep.consultaCep(usuario.getCep());		
			//enderecoService.salvarEndereco(endereco);
			
			
			return ResponseEntity.ok("Usuario salvo com sucesso");
	}
	}
	*/
	@PutMapping
	public ResponseEntity alterarUsuario(@RequestBody Usuario usuario) {
		

		//LocalDate dataNascimento = usuario.getNascimento();
		//usuario.setNascimento(dataNascimento);
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
