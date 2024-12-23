package com.crudspring.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/oi")
public class UsuarioController {

@GetMapping
	public String index() {
		return "Ola";
	}

}
