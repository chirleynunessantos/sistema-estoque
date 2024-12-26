package com.crudspring.crud.model;

public enum UsuarioRoles {

	ADMIN("admin"),
	USUARIO("usuario");
	
	private String role;
	
	UsuarioRoles(String role){
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
