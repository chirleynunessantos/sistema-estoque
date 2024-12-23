package com.crudspring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspring.crud.model.Produto;

public interface  ProductRepository extends JpaRepository<Produto,String> {

}
