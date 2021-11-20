package org.serratec.backend.projetoFinal.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ProdutoService {
	
	@Autowired
    private static ProdutoRepository produtoRepository;	

    private Produto addImageUrl(Produto produto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/image")
                .buildAndExpand(produto.getId()).toUri();
        Produto produto1 = new Produto();
        produto1.setNome(produto1.getNome());
        produto1.setCategoria(produto1.getCategoria());
        return produto1;

    }
    

    public  Optional<List<Produto>> listarTodosService() {
    	Optional<List<Produto>> produto = Optional.ofNullable(produtoRepository.findAll());
    
    	return produto;
    }
    
    
    public  Optional<Produto> listar(Long id) {
    	Optional<Produto> produto = produtoRepository.findById(id);
    	
    	return produto;
    }

    public Produto cadastrarProduto(Produto produto) {
    	produtoRepository.save(produto);
    	
    	return produto;
    }


    public Optional<Produto> atualizarService(Long id, Produto dadosProduto) {
    	Optional<Produto> produto = produtoRepository.findById(id);
    	
    	if (!produto.isPresent()) {
    		return produto;
    	}
    	dadosProduto.setId(id);
    	produtoRepository.save(dadosProduto);
    	
    	return produto;
    }
    
    public boolean deletar(Long id) {
    	
    	if (!produtoRepository.existsById(id)) {
    		return false;
    	}
    	produtoRepository.deleteById(id);
    	return true;
    }
    
    
    
}