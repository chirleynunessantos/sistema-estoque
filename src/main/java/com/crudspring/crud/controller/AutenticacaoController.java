package com.crudspring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspring.crud.model.AutenticacaoDTO;
import com.crudspring.crud.model.ResgistroDTO;
import com.crudspring.crud.model.Usuario;
import com.crudspring.crud.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	  @Autowired
	    private UsuarioRepository repository;
	    @Autowired
	    private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data) {
		var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = authenticationManager.authenticate(userNamePassword);
		return ResponseEntity.ok().build();
	}
	  @PostMapping("/register")
	    public ResponseEntity register(@RequestBody @Valid ResgistroDTO data){
	        if(this.repository.findByEmail(data.login()) != null) return ResponseEntity.badRequest().build();

	        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
	        Usuario novoUsuario = new Usuario(data.login(), encryptedPassword, data.role());

	        this.repository.save(novoUsuario);

	        return ResponseEntity.ok().build();
	    }
}
