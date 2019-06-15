package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "tb_aluguel")
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "al_codigo")
	private Long codigo;

	@Column(name = "al_valor_total")
	private BigDecimal valorTotal;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "codigo_apolice_seguro")
	private ApoliceSeguro apoliceSeguro;

	@ManyToOne
	@JoinColumn(name = "codigo_carro")
	private Carro carro;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}

	public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apoliceSeguro == null) ? 0 : apoliceSeguro.hashCode());
		result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		Aluguel other = (Aluguel) obj;
		if (apoliceSeguro == null) {
			if (other.apoliceSeguro != null)
				return false;
		} else if (!apoliceSeguro.equals(other.apoliceSeguro))
			return false;
		if (carro == null) {
			if (other.carro != null)
				return false;
		} else if (!carro.equals(other.carro))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

}
