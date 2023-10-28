package br.com.descomplica.projeto.documentacao.entity;

import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer pedidoId;

	@Column(name = "pedido_data")
	private LocalTime pedidoData;

	@ManyToMany
	Set<Turma> produtos;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalTime getPedidoData() {
		return pedidoData;
	}

	public void setPedidoData(LocalTime pedidoData) {
		this.pedidoData = pedidoData;
	}

	public Set<Turma> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Turma> produtos) {
		this.produtos = produtos;
	}

}