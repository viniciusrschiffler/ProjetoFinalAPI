package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.domain.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem,Long> {
    
}
