package com.crudspring.crud.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice_in_cents() {
		return price_in_cents;
	}

	public void setPrice_in_cents(Integer price_in_cents) {
		this.price_in_cents = price_in_cents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price_in_cents);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(price_in_cents, other.price_in_cents);
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(String id, String name, Integer price_in_cents) {
		super();
		this.id = id;
		this.name = name;
		this.price_in_cents = price_in_cents;
	}

	@Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;

    public Produto(RequestProduto requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }
	    
}
