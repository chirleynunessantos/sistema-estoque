package com.crudspring.crud.consomeapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("consulta-cep")
public class ConsultaCepApi {

	@GetMapping("/{cep}")
	public CepResultDTOP consultaCep(@PathVariable("cep") String cep){
		
		
		RestTemplate restTamplate =  new RestTemplate();
		ResponseEntity<CepResultDTOP> response =  
				restTamplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json",cep), CepResultDTOP.class);
			System.out.println("aqui");	
		return response.getBody();
	}
	
	
}
