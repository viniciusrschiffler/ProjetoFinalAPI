package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemPedidoService {
	
	@Autowired
	private static ItemPedidoRepository itemPedidoRespository;
	
	public static Optional<List<ItemPedido>> listarTodosService() {
		Optional<List<ItemPedido>> itemPedido = Optional.ofNullable(itemPedidoRespository.findAll());
		
		return itemPedido;
	}
}
