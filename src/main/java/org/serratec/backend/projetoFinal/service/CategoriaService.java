package org.serratec.backend.projetoFinal.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.serratec.backend.projetoFinal.domain.Categoria;
import org.serratec.backend.projetoFinal.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public Categoria salvarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    public Optional<Categoria> encontrarCategoria(Long id) {
        return repository.findById(id);
    }

    public void deletarCategoria(Long id) {
        Optional<Categoria> categoriaExistente = repository.findById(id);
        if (categoriaExistente.isPresent())
            repository.deleteById(id);
    }

    public List<Categoria> retornaTodasCategorias() {
        List<Categoria> todasCategorias = repository.findAll();
        return !todasCategorias.isEmpty() ? todasCategorias : Collections.emptyList();
    }



}
