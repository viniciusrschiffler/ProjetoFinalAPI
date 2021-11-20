package org.serratec.backend.projetoFinal.controller;

import java.util.List;


import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.dto.ClienteDto;
import org.serratec.backend.projetoFinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> cliente = clienteService.listar();
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/dto")
	public ResponseEntity<List<ClienteDto>> findAll(){
		List<ClienteDto> cliente = clienteService.findAll();
		return ResponseEntity.ok(cliente);
		
	}
	

	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id){
		Cliente cliente = clienteService.buscarCliente(id);
		if(null != cliente) {
			return ResponseEntity.ok(cliente);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> inserir( @Valid @RequestBody Cliente cliente){
		Cliente cliente1 = clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente1);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id,@Valid @RequestBody Cliente cliente){
			Cliente cliente1 = clienteService.atualizar(id, cliente);
			if( null != cliente1) {
				
				return ResponseEntity.ok(cliente1);
			}
			else {
				return ResponseEntity.notFound().build();
			}
			
		}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		boolean cliente1 = clienteService.delete(id);
		
		if(false == cliente1) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}

}
