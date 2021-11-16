package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
