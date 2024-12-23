package com.crudspring.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="endereco")
@Entity(name="endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	@Id
	String cep;
	String Pais;
	String Estado;
	String cidade;

	String bairro;
	String rua;
	int numero;
	String complemento;
	
	
	
}
