package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.mail.MailConfig;
import org.serratec.backend.projetoFinal.repository.ClienteRepository;
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
	private MailConfig mailConfig;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir( @Valid @RequestBody Cliente cliente){
		clienteRepository.save(cliente);
		mailConfig.sendEmail(cliente.getEmail(), "Cadastro Efetuado", cliente.toString() );
		return cliente;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
			Optional<Cliente> cliente1 = clienteRepository.findById(id);
			if(cliente1.isPresent()) {
				
			if(null != cliente.getTelefone()) {
				cliente1.get().setTelefone(cliente.getTelefone());
			}
			if(null !=cliente.getCpf()) {
				cliente1.get().setCpf(cliente.getCpf());
			}
			if(null !=cliente.getNomeCompleto()) {
				cliente1.get().setNomeCompleto(cliente.getNomeCompleto());
			}
			if(null !=cliente.getEmail()) {
				cliente1.get().setEmail(cliente.getEmail());
			}
			if(null !=cliente.getEndereco()) {
				cliente1.get().setEndereco(cliente.getEndereco());
			}
			if(null !=cliente.getDataNascimento()) {
				cliente1.get().setDataNascimento(cliente.getDataNascimento());
			}
			if(null !=cliente.getNomeUsuario()) {
				cliente1.get().setNomeUsuario(cliente.getNomeUsuario());
			}
			if(null !=cliente.getSenha()) {
				cliente1.get().setSenha(cliente.getSenha());
			}
		}
		else {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clienteRepository.save(cliente1.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
