package org.serratec.backend.projetoFinal.service;

import java.net.URI;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ProdutoService {

    private Produto addImageUrl(Produto produto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/image")
                .buildAndExpand(produto.getId()).toUri();
        Produto produto1 = new Produto();
        produto1.setNome(produto1.getNome());
        produto1.setCategoria(produto1.getCategoria());
        return produto1;

    }
}