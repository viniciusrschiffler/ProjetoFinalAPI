package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Pedido;
import org.serratec.backend.projetoFinal.service.PedidoService;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping("/pedido")
	public class PedidoController {

		@Autowired
		private PedidoService pedidoService;
		
		@GetMapping("/todos")
		public ResponseEntity<List<Pedido>> listarTodos() {
			Optional<List<Pedido>> pedido = pedidoService.listarTodos();
			
			if(pedido.isPresent()) {
				return ResponseEntity.ok(pedido.get());
			}
			
			return ResponseEntity.notFound().build();
		}
		
		@GetMapping("/listar/{id}")

		@ApiOperation(value = "Retorna um pedido especifico", notes = "Listagem de Pedidos")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Recurso não encotrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })


		public ResponseEntity<Pedido> listar(@PathVariable Long id) {
			
			Optional<Pedido> pedido = pedidoService.listar(id);
			
			if(pedido.isPresent()) {
				return ResponseEntity.ok(pedido.get());
			}
			
			return ResponseEntity.notFound().build();
		}
		@PostMapping("/cadastrar")
		
		@ApiOperation(value = "Salva um pedido")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido Salvo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Recurso não encotrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

		public ResponseEntity<Void> cadastrarPedido(@Valid @RequestBody Pedido pedido) {
			
			boolean foiCadastrado = pedidoService.cadastrarPedido(pedido);
			if (foiCadastrado) {
				return ResponseEntity.status(201).build();
			}
			else {
				return ResponseEntity.internalServerError().build();
			}
		}
		
		
		@PutMapping("/atualizar/{id}")

		@ApiOperation(value = "Atualiza um pedido especifico")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Recurso não encotrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

		public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido dadosPedido) {
			
			Optional<Pedido> pedido = pedidoService.atualizar(id, dadosPedido);
			
			if (!pedido.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(pedido.get());
		}
		
		@DeleteMapping("/deletar/{id}")

		@ApiOperation(value = "Deleta um pedido especifico")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido Deletado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Recurso não encotrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

		public ResponseEntity<Void> deletar(@PathVariable Long id) {
			boolean foiDeletado = pedidoService.deletar(id);
			
			if (!foiDeletado) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.noContent().build();
		}

	}
