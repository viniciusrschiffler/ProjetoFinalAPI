package org.serratec.backend.projetoFinal.controller;

import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.EnderecoViaCep;
import org.serratec.backend.projetoFinal.service.EnderecoViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecoViaCep")
public class EnderecoViaCepController {
	
	@Autowired
	private EnderecoViaCepService enderecoViaCepService;
	
	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoViaCep> buscar(@PathVariable String cep) {
		
			Optional<EnderecoViaCep> enderecoViaCepSite = enderecoViaCepService.buscarService(cep) ;

			if (enderecoViaCepSite.get().getCep() !=null && enderecoViaCepSite != null) {
				return ResponseEntity.ok(enderecoViaCepSite.get());
			} else {
				return ResponseEntity.notFound().build();
			}
	}	

}
