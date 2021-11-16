package org.serratec.backend.projetoFinal.domain;

import java.time.LocalDate;
import java.util.Arrays;
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
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;
	
	@NotBlank(message = "Prencher nome")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String nome;
	
	@Size(max = 100)
	@Column(nullable = true, length = 100)
	private String descricao;
	
	@NotBlank(message = "Prencher quantidade em estoque")
	@Column(nullable = false, name = "qtd_estoque")
	private Integer qtdEstoque;
	
	@Column(nullable = true, name = "data_cadastro")
	private LocalDate dataCadastro;
	
	@NotBlank(message = "Prencher valor unitario")
	@Column(nullable = false, name = "valor_unitario")
	private Float valorUnitario;
	
	@Column(nullable = true)
	private byte[] imagem;
	
	@OneToOne
	@JoinColumn(name = "id_categoria")
//	@Column(name = "id_categoria")
	private Categoria categoria;

	public Produto() {
		super();
	}

	public Produto(Long id, @NotBlank(message = "Prencher nome") @Size(max = 30) String nome,
			@Size(max = 100) String descricao, @NotBlank(message = "Prencher quantidade em estoque") Integer qtdEstoque,
			LocalDate dataCadastro, @NotBlank(message = "Prencher valor unitario") Float valorUnitario, byte[] imagem,
			Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Categoria getProduto() {
		return categoria;
	}

	public void setProduto(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagem);
		result = prime * result + Objects.hash(categoria, dataCadastro, descricao, id, nome, qtdEstoque, valorUnitario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Arrays.equals(imagem, other.imagem) && Objects.equals(nome, other.nome)
				&& Objects.equals(qtdEstoque, other.qtdEstoque) && Objects.equals(valorUnitario, other.valorUnitario);
	}
	
	
}
