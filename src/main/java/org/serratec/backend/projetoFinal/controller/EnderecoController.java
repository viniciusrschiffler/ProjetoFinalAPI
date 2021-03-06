package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.serratec.backend.projetoFinal.domain.Endereco;
import org.serratec.backend.projetoFinal.service.EnderecoService;
import org.serratec.backend.projetoFinal.service.EnderecoViaCepService;
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
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoViaCepService viaCepService;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Endereco>> listarTodos() {
		
		Optional<List<Endereco>> endereco = enderecoService.listarTodosService();
		
		if(endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Endereco> listar(@PathVariable Long id) {
		
		Optional<Endereco> endereco = enderecoService.listarService(id);
		
		if(endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Void> cadastrarEndereco(@Valid @RequestBody Endereco endereco) {
		
		enderecoService.cadastrarService(endereco);
		return ResponseEntity.status(201).build();
	}
	
	@PostMapping("/cadastrarPorCep")
	public ResponseEntity<Endereco> cadastrarEnderecoPorCep(@PathParam("cep") String cep, @PathParam("numero") Integer numero, @PathParam("complemento") String complemento) {
		
		Endereco enderecoViaCepSite = viaCepService.buscarService(cep, numero) ;

		if (enderecoViaCepSite != null) {
		
			
			if (complemento != null) {
				enderecoViaCepSite.setComplemento(complemento);
			}
			
			enderecoService.cadastrarService(enderecoViaCepSite);
			
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @Valid @RequestBody Endereco dadosEndereco) {
		
		Optional<Endereco> endereco = enderecoService.atualizarService(id, dadosEndereco);
		
		if (!endereco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(endereco.get());
		
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		boolean foiDeletada = enderecoService.deletar(id);
		if (!foiDeletada) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.noContent().build();
	}
}
