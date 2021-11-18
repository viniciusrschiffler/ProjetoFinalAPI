package org.serratec.backend.projetoFinal.service;

import java.net.URI;

import org.serratec.backend.projetoFinal.DTO.ProdutoDTO;
import org.serratec.backend.projetoFinal.domain.Produto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ProdutoService {

	private ProdutoDTO addImageUrl(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/image")
				.buildAndExpand(produto.getId().toUri());
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setNome(produto.getNome());
		produtoDTO.setCategoria(produto.getCategoria());
		return produtoDTO;
		
	}
}
