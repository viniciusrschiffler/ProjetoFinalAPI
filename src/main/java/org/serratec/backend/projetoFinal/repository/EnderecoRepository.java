package org.serratec.backend.projetoFinal.Repository;

import org.serratec.backend.projetoFinal.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long>{

}


