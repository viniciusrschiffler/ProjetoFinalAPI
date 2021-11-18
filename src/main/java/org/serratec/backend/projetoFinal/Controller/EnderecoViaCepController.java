package org.serratec.backend.projetoFinal.controller;

import java.net.URI;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.EnderecoViaCep;
import org.serratec.backend.projetoFinal.repository.EnderecoViaCepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/enderecoViaCep")
public class EnderecoViaCepController {

	@Autowired
	private EnderecoViaCepRepository enderecoViaCepRepository;

	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoViaCep> buscar(@PathVariable String cep) {
		Optional<EnderecoViaCep> enderecoViaCep = Optional.ofNullable(enderecoViaCepRepository.findByCep(cep));
		
		if (enderecoViaCep.isPresent()) {
			return ResponseEntity.ok(enderecoViaCep.get());
		} else {
			
			try {
				RestTemplate restTemplate = new RestTemplate();
				String uri = "https://viacep.com.br/ws/" + cep + "/json/";
				Optional<EnderecoViaCep> enderecoViaCepSite = Optional.ofNullable(restTemplate.getForObject(uri, EnderecoViaCep.class));

				if (enderecoViaCepSite.get().getCep() !=null) {
					return inserir(enderecoViaCepSite.get());
				} else {
					return ResponseEntity.notFound().build();
				}
				
			} catch (HttpClientErrorException e) {
				return ResponseEntity.notFound().build();
			}
		}
	}	

	@PostMapping
	public ResponseEntity<EnderecoViaCep> inserir(@RequestBody EnderecoViaCep enderecoViaCep) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand(enderecoViaCep.getCep()).toUri();
		enderecoViaCep = enderecoViaCepRepository.save(enderecoViaCep);
		return ResponseEntity.created(uri).body(enderecoViaCep);
	}
}
