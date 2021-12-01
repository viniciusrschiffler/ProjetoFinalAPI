package org.serratec.backend.projetoFinal.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
	
	@NotNull
	@Column(nullable = false, name = "qtd_estoque")
	private Integer qtdEstoque;
	
	@Column(nullable = true, name = "data_cadastro")
	private LocalDate dataCadastro;
	
	@NotNull
	@Column(nullable = false, name = "valor_compra")
	private Float valorCompra;
	
	@NotNull
	@Column(nullable = false, name = "valor_aluguel")
	private Float valorAluguel;
	
	@Column(nullable = true, name = "imagem")
	private String imagem;
	
	@Column(nullable = true, name = "imagemFundo")
	private String imagemFundo;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_categoria")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	public Produto() {
		super();
	}
	
	
	public Produto(Long id) {
		super();
		this.id = id;
	}


	public Produto(Long id, @NotBlank(message = "Prencher nome") @Size(max = 30) String nome,
			@Size(max = 100) String descricao, @NotNull Integer qtdEstoque, LocalDate dataCadastro,
			@NotNull Float valorCompra, @NotNull Float valorAluguel, String imagem, String imagemFundo,
			Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorCompra = valorCompra;
		this.valorAluguel = valorAluguel;
		this.imagem = imagem;
		this.imagemFundo = imagemFundo;
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


	public Float getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(Float valorCompra) {
		this.valorCompra = valorCompra;
	}


	public Float getValorAluguel() {
		return valorAluguel;
	}


	public void setValorAluguel(Float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public String getImagemFundo() {
		return imagemFundo;
	}


	public void setImagemFundo(String imagemFundo) {
		this.imagemFundo = imagemFundo;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categoria, dataCadastro, descricao, id, imagem, imagemFundo, nome, qtdEstoque, valorAluguel,
				valorCompra);
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
				&& Objects.equals(imagem, other.imagem) && Objects.equals(imagemFundo, other.imagemFundo)
				&& Objects.equals(nome, other.nome) && Objects.equals(qtdEstoque, other.qtdEstoque)
				&& Objects.equals(valorAluguel, other.valorAluguel) && Objects.equals(valorCompra, other.valorCompra);
	}


	


	
	
	
}
