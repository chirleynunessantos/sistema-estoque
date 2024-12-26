package com.crudspring.crud.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity(name="usuario")
@Table(name="usuario")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {
	
	//String name;
	
//	private String cpf;
	//private LocalDate nascimento;
	@Id
	private String email;
	private String senha;
	private UsuarioRoles role;
	

	public Usuario(String email, String senha, UsuarioRoles role) {
		super();
		this.email = email;
		this.senha = senha;
		this.role = role;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role== UsuarioRoles.ADMIN) {
			return List.of(
					new SimpleGrantedAuthority("ROLE_ADMIN"),
					new SimpleGrantedAuthority("ROLE_USER")
					);
		}else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	
}
