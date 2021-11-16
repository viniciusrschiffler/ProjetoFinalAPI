package org.serratec.backend.projetoFinal.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@NotBlank(message = "Prencher email")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String email;
	
	@NotBlank(message = "Prencher nome do usuario ")
	@Size(max = 20)
	@Column(nullable = false, length = 20, name = "nome_usuario")
	private String nomeUsuario;
	
	@NotBlank(message = "Prencher seu nome completo")
	@Size(max = 60)
	@Column(nullable = false, length = 60, name = "nome_completo")
	private String nomeCompleto;
	
	@NotBlank(message = "Prencher senha")
	@Size(max = 255)
	@Column(nullable = true, length = 255)
	private String senha;
	
	@NotBlank(message = "Prencher cpf")
	@Size(max = 14)
	@Column(nullable = false, length = 14)
	private String cpf;
	
	@NotBlank(message = "Prencher telefone")
	@Size(max = 11)
	@Column(nullable = true, length = 11)
	private String telefone;
	
	@NotBlank(message = "Prencher data de nascimento")
	@Column(nullable = true, name = "data_nasc")
	private LocalDate dataNascimento;
	
	@OneToOne
	@JoinColumn(name = "id_endereco")
//	@Column(name = "id_endereco")
	private Endereco endereco;

	public Cliente() {
		super();
	}

	
	

	public Cliente(Long id, @NotBlank(message = "Prencher email") @Size(max = 30) String email,
			@NotBlank(message = "Prencher nome do usuario ") @Size(max = 20) String nomeUsuario,
			@NotBlank(message = "Prencher seu nome completo") @Size(max = 60) String nomeCompleto,
			@NotBlank(message = "Prencher senha") @Size(max = 255) String senha,
			@NotBlank(message = "Prencher cpf") @Size(max = 14) String cpf,
			@NotBlank(message = "Prencher telefone") @Size(max = 11) String telefone,
			@NotBlank(message = "Prencher data de nascimento") LocalDate dataNascimento, Endereco endereco) {
		super();
		this.id = id;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}




	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, email, endereco, id, nomeCompleto, nomeUsuario, senha, telefone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(nomeCompleto, other.nomeCompleto)
				&& Objects.equals(nomeUsuario, other.nomeUsuario) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone);
	}
	
	
	
}
