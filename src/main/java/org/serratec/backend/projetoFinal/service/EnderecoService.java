package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Endereco;
import org.serratec.backend.projetoFinal.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Optional<List<Endereco>> listarTodosService() {
		Optional<List<Endereco>> endereco = Optional.ofNullable(enderecoRepository.findAll());
		
			return endereco;
	}
	
	public Optional<Endereco> listarService( Long id) {
		
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		
		return endereco;
	}
	
	public Endereco cadastrarService(Endereco endereco) {
		
		enderecoRepository.save(endereco);
		
		return endereco;
	}
	
	public Optional<Endereco> atualizarService(Long id, Endereco dadosEndereco) {
		
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		
		if (!endereco.isPresent()) {
			return endereco;
		}
		dadosEndereco.setId(id);
		enderecoRepository.save(dadosEndereco);
		
		return endereco;
	}
	
	public boolean deletar(Long id) {
		
		if (!enderecoRepository.existsById(id)) {
			return false;
		}
		enderecoRepository.deleteById(id);
		return true;
	}
}
