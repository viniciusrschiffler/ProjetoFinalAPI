package org.serratec.backend.projetoFinal.Repository;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}