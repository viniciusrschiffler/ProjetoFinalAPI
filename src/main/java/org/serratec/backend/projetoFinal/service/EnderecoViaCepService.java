package org.serratec.backend.projetoFinal.service;

import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Endereco;
import org.serratec.backend.projetoFinal.domain.EnderecoViaCep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoViaCepService {
	
	public Endereco buscarService(String cep, Integer numero) {
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<EnderecoViaCep> enderecoViaCepSite = Optional.ofNullable(restTemplate.getForObject(uri, EnderecoViaCep.class));
			
			String rua = enderecoViaCepSite.get().getLogradouro();
			String bairro = enderecoViaCepSite.get().getBairro();
			String cidade = enderecoViaCepSite.get().getLocalidade();
			String estado = enderecoViaCepSite.get().getUf();
			
			
			Endereco endereco = new Endereco(cep, rua, bairro, cidade, numero, estado);
			
			return endereco;
				
		} catch (HttpClientErrorException e) {
			return null;
		}
	}	

}
