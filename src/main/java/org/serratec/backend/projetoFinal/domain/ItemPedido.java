package org.serratec.backend.projetoFinal.domain;

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
}
