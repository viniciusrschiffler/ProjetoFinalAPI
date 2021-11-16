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
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	
	@NotBlank(message = "Prencher data do pedido")
	@Column(nullable = false, name = "data_pedido")
	private LocalDate dataPedido;
	
	@NotBlank(message = "Prencher data de entrega")
	@Column(nullable = true, name = "data_entrega")
	private LocalDate dataEntrega ;
	
	@NotBlank(message = "Prencher data de envio")
	@Column(nullable = true, name = "data_envio")
	private LocalDate dataEnvio;
	
	@NotBlank(message = "Prencher status")
	@Size(max = 20)
	@Column(nullable = true, length = 20)
	private String status;
	
	@OneToOne
	@JoinColumn(name = "id_cliente")
//	@Column(name = "id_cliente")
	private Cliente cliente;
	

	public Pedido() {
		super();
	}

	public Pedido(Long id, @NotBlank(message = "Prencher data do pedido") LocalDate dataPedido,
			@NotBlank(message = "Prencher data de entrega") LocalDate dataEntrega,
			@NotBlank(message = "Prencher data de envio") LocalDate dataEnvio,
			@NotBlank(message = "Prencher status") @Size(max = 20) String status, Cliente cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataEntrega, dataEnvio, dataPedido, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataEntrega, other.dataEntrega)
				&& Objects.equals(dataEnvio, other.dataEnvio) && Objects.equals(dataPedido, other.dataPedido)
				&& Objects.equals(id, other.id) && Objects.equals(status, other.status);
	}
	
	
	
	
}
