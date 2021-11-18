package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.repository.PedidoRepository;
import org.serratec.backend.projetoFinal.domain.Pedido;
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
	@RequestMapping("/pedido")
	public class PedidoController {
	
		@Autowired
		private PedidoRepository pedidoRepository;
		
		@GetMapping("/todos")
		public ResponseEntity<List<Pedido>> listarTodos() {
			
			Optional<List<Pedido>> pedido = Optional.ofNullable(pedidoRepository.findAll());
			
			if(pedido.isPresent()) {
				return ResponseEntity.ok(pedido.get());
			}
			
			return ResponseEntity.notFound().build();
		}
		
		@GetMapping("/listar/{id}")
		public ResponseEntity<Pedido> listar(@PathVariable Long id) {
			
			Optional<Pedido> pedido = pedidoRepository.findById(id);
			
			if(pedido.isPresent()) {
				return ResponseEntity.ok(pedido.get());
			}
			
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping("/cadastrar")
		public ResponseEntity<Void> cadastrarPedido(@RequestBody Pedido pedido) {
			
			pedidoRepository.save(pedido);
			return ResponseEntity.status(201).build();
		}
		
		@PutMapping("/atualizar/{id}")
		public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido dadosPedido) {
			
			Optional<Pedido> pedido = pedidoRepository.findById(id);
			
			if (!pedido.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			dadosPedido.setId(id);
			pedidoRepository.save(dadosPedido);
			return ResponseEntity.ok(pedido.get());
			
		}
		
		@DeleteMapping("/deletar/{id}")
		public ResponseEntity<Void> deletar(@PathVariable Long id) {
			
			if (!pedidoRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			pedidoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
}

