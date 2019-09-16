package com.euhenriquemarques.produtos.APIREST.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.euhenriquemarques.produtos.APIREST.Repository.ProdutoRepository;
import com.euhenriquemarques.produtos.APIREST.models.Produto;

//como é uma api rest, devemos anotar como rest controller
@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	
	/* fazendo injeção de dependencias dentro da classe controller
	 */
	
	@Autowired
	private ProdutoRepository pr;
	
	/* metodo abaixo busca os valores dentro do banco, o repository tem o metodo faça o select 
	 */
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return pr.findAll();
	}
	
	
   /*realizo a busca dos produtos de acordo com o id deles,
	*passo o numero do id depois da "/"
	*na anotacao do metodo eu coloco o id, e depois eu busco ele pelo
	*repository, mas no repository eu fiz um metodo para ele buscar por id
    */
	
	@GetMapping("/produtos/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return pr.findById(id);		
	}
	
	/* metodo abaixo salva os valores dentro do banco, o repository tem o metodo save que 
	 * ja serve para enviar as informaões para o banco 
	 */
	
	@PostMapping("produtos")
	public Produto gravar(@RequestBody @Valid Produto produto) {
		return pr.save(produto);
	}
	
	/* metodo abaixo deleta os valores dentro do banco, o repository tem o metodo delete que 
	 * ja serve para excluir as informaões para o banco 
	 */
	
	@DeleteMapping("/produtos")
	public void deletarProduto(@RequestBody Produto produto) {
		pr.delete(produto);
	}
	
	
	
	/* metodo abaixo atualiza os valores dentro do banco, o repository tem o metodo save que 
	 * ja serve para enviar as informaões para o banco fazendo o update
	 */
	
	@PutMapping("produtos")
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return pr.save(produto);
	}
	

}
