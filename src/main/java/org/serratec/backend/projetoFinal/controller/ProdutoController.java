package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.serratec.backend.projetoFinal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> listarTodos() {
		Optional<List<Produto>> produto = produtoService.listarTodosService();
		
		if(produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Produto> listar(@PathVariable Long id) {
		Optional<Produto> produto = produtoService.listar(id);
		
		if(produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Void> cadastrarProduto(@Valid @RequestBody Produto produto) {
		produtoRepository.save(produto);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto dadosProduto) {
		
		Optional<Produto> produto = produtoService.atualizarService(id, dadosProduto);
		
		if (!produto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto.get());
		
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		boolean foiDeletado = produtoService.deletar(id);
		if(!foiDeletado) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}