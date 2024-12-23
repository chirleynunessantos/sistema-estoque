package com.crudspring.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspring.crud.model.Produto;
import com.crudspring.crud.model.RequestProduto;
import com.crudspring.crud.repository.ProductRepository;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/produto")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	@GetMapping()
	public  ResponseEntity buscarProduto() {
		//List<Produto>
		 List<Produto> produtos  = repository.findAll();
		
	System.out.println(produtos);
	
		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable("id") String id) {
		
	Optional<Produto> produto =  repository.findById(id);

	return ResponseEntity.ok(produto.get());	
	}
	
	@PostMapping
	public ResponseEntity salvarProduto(@RequestBody @Valid RequestProduto dados) {
		System.out.println(dados);
		Produto produtos = new Produto(dados);
		repository.save(produtos);
		return ResponseEntity.ok("oi");
	}
	/*
	 @PutMapping
	    @Transactional
	    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){
	        Optional<Product> optionalProduct = repository.findById(data.id());
	        if (optionalProduct.isPresent()) {
	            Product product = optionalProduct.get();
	            product.setName(data.name());
	            product.setPrice_in_cents(data.price_in_cents());
	            return ResponseEntity.ok(product);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }*/
}
