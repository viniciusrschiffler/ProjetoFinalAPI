package org.serratec.backend.projetoFinal.controller;

import org.serratec.backend.projetoFinal.domain.Categoria;
import org.serratec.backend.projetoFinal.repository.CategoriaRepository;
import org.serratec.backend.projetoFinal.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria){
        Categoria categoriaSalva = service.salvarCategoria(categoria);

        return new ResponseEntity<>(categoriaSalva, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoria(@PathVariable Long id){
        Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);
        if(categoriaExistente.isPresent()) {
            return ResponseEntity.ok(categoriaExistente);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoria(@PathVariable Long id) {
        Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);
        if(categoriaExistente.isPresent()){
            service.deletarCategoria(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/todos")
    public ResponseEntity retornaTodos() {
        List<Categoria> todasCategorias = service.retornaTodasCategorias();
        if(!todasCategorias.isEmpty()) {
            return ResponseEntity.ok(todasCategorias);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {

        Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);

        if (!categoriaExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        service.salvarCategoria(categoria);
        return ResponseEntity.ok(categoriaExistente.get());

    }
}
