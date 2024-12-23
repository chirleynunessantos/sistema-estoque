package com.crudspring.crud.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduto(
		String id,

        @NotBlank
        String name,
        @NotNull
        Integer price_in_cents
		
		
		) {



}
