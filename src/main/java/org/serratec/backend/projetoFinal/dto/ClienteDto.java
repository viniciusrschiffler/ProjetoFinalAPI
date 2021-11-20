package org.serratec.backend.projetoFinal.dto;


import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.projetoFinal.domain.Cliente;


public class ClienteDto {
	private Long id;
	private String nomeCompleto;
	private String cpf;
	private String telefone;
	
	
	public ClienteDto() {
		
	}

	public ClienteDto(Long id,String nomeCompleto, String cpf, String telefone) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.telefone = telefone;
		
	}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		
	}
	
	public static List<ClienteDto> convert(List<Cliente> clientes){
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
