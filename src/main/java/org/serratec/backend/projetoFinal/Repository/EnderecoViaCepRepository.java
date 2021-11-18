package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.domain.EnderecoViaCep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoViaCepRepository extends JpaRepository<EnderecoViaCep,Long> {
	
	public EnderecoViaCep findByCep(String cep);
}