package org.serratec.backend.projetoFinal.controller;

import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.EnderecoViaCep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/enderecoViaCep")
public class EnderecoViaCepController {

	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoViaCep> buscar(@PathVariable String cep) {
			
		try {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<EnderecoViaCep> enderecoViaCepSite = Optional.ofNullable(restTemplate.getForObject(uri, EnderecoViaCep.class));

			if (enderecoViaCepSite.get().getCep() !=null) {
				return ResponseEntity.ok(enderecoViaCepSite.get());
			} else {
				return ResponseEntity.notFound().build();
			}
				
		} catch (HttpClientErrorException e) {
			return ResponseEntity.notFound().build();
		}
	}	

}
