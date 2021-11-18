package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Endereco;
import org.serratec.backend.projetoFinal.repository.EnderecoRepository;
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
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Endereco>> listarTodos() {
		
		Optional<List<Endereco>> endereco = Optional.ofNullable(enderecoRepository.findAll());
		
		if(endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Endereco> listar(@PathVariable Long id) {
		
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		
		if(endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Void> cadastrarEndereco(@RequestBody Endereco endereco) {
		
		enderecoRepository.save(endereco);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @RequestBody Endereco dadosEndereco) {
		
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		
		if (!endereco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		dadosEndereco.setId(id);
		enderecoRepository.save(dadosEndereco);
		return ResponseEntity.ok(endereco.get());
		
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		if (!enderecoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		enderecoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
