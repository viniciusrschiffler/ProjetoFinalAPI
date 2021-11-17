package org.serratec.backend.projetoFinal.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "item_pedido", schema = "public")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Long id;
	
	@NotBlank(message = "Prencher quantidade")
	@Column(nullable = false)
	private Integer quantidade;
	
	
	@NotBlank(message = "Prencher nome")
	@Column(nullable = false)
	private Integer precoVenda;
	
	@OneToOne
	@JoinColumn(name = "id_pedido")
//	@Column(name = "id_pedido")
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name = "id_produto")
//	@Column(name = "id_produto")
	private Produto produto;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Long id, @NotBlank(message = "Prencher quantidade") Integer quantidade,
			@NotBlank(message = "Prencher nome") Integer precoVenda, Pedido pedido, Produto produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Integer precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pedido, precoVenda, produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(precoVenda, other.precoVenda) && Objects.equals(produto, other.produto)
				&& Objects.equals(quantidade, other.quantidade);
	}
	
	
}
