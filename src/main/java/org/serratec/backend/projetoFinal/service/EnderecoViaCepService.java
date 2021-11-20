package org.serratec.backend.projetoFinal.service;

import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.EnderecoViaCep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoViaCepService {
	
	public Optional<EnderecoViaCep> buscarService(String cep) {
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<EnderecoViaCep> enderecoViaCepSite = Optional.ofNullable(restTemplate.getForObject(uri, EnderecoViaCep.class));
			
			return enderecoViaCepSite;
				
		} catch (HttpClientErrorException e) {
			return null;
		}
	}	

}
