package org.serratec.backend.projetoFinal.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.websocket.OnMessage;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;
	
	@NotBlank(message = "Preencher cep")
	@Size(max = 9)
	@Column(nullable = false, length = 9)
	private String cep;
	
	@NotBlank(message = "Preencher rua")
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String rua;
	
	@NotBlank(message = "Preencher bairro")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String bairro;
	
	@Size(max = 30)
	@Column(nullable = true, length = 30)
	private String cidade;
	
	@NotNull(message = "Preencher Número")
	@Column(nullable = false)
	private Integer numero;
	
	@Size(max = 20)
	@Column(nullable = true, length = 20)
	private String complemento;
	
	@Size(max = 2)
	@Column(nullable = true, length = 2)
	private String estado;

	
	public Endereco() {
		super();
	}


	public Endereco(Long id) {
		this.id = id;
	}


	public Endereco(Long id, @NotBlank(message = "Prencher cep") @Size(max = 9) String cep,
			@NotBlank(message = "Prencher rua") @Size(max = 100) String rua,
			@NotBlank(message = "Prencher bairro") @Size(max = 50) String bairro,
			@NotBlank(message = "Prencher cidade") @Size(max = 30) String cidade,
			@NotBlank(message = "Prencher numero") Integer numero,
			@NotBlank(message = "Prencher complemento") @Size(max = 20) String complemento,
			@NotBlank(message = "Prencher estado") @Size(max = 2) String estado) {
		super();
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
		this.estado = estado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, estado, id, numero, rua);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero) && Objects.equals(rua, other.rua);
	}
	
	
}
