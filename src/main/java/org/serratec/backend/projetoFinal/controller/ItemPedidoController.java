package org.serratec.backend.projetoFinal.Controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.Repository.ItemPedidoRepository;
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
@RequestMapping("/itemPedido")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRespository;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> listarTodos() {
		Optional<List<ItemPedido>> itemPedido = Optional.ofNullable(itemPedidoRespository.findAll());
		
		if (!itemPedido.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(itemPedido.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Long id) {
		Optional<ItemPedido> itemPedido = itemPedidoRespository.findById(id);
		
		if (!itemPedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(itemPedido.get());
	}
	
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody ItemPedido dadosItemPedido) {
		
		itemPedidoRespository.save(dadosItemPedido);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> atualizar(@PathVariable Long id, @RequestBody ItemPedido dadosItemPedido) {
		Optional<ItemPedido> itemPedido = itemPedidoRespository.findById(id);
		
		if (!itemPedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		if (dadosItemPedido.getId() == null) {
			dadosItemPedido.setId(id);
		}
		
		
		itemPedidoRespository.save(dadosItemPedido);
		
		return ResponseEntity.ok(itemPedido.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		if (!itemPedidoRespository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		itemPedidoRespository.deleteById(id);
		return ResponseEntity.ok("Usúario Deletado com sucesso");
	}
	
	
	
	
	
}
