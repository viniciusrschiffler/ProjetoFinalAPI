package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}


