package com.euhenriquemarques.produtos.APIREST.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.euhenriquemarques.produtos.APIREST.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);

}
