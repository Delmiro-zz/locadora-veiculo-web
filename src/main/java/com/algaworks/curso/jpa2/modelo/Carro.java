package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "tb_carro")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ca_codigo")
	private Long codigo;

	@Column(name = "ca_placa")
	private String placa;

	@Column(name = "ca_cor")
	private String cor;

	@Column(name = "ca_valorDiaria")
	private BigDecimal valorDiaria;

	@ManyToOne
	@JoinColumn(name = "ca_codigo_modelo_carro")
	private ModeloCarro modeloCarro;

	@ManyToMany
	@JoinColumn(name = "ca_codigo_acessorio")
	private List<Acessorio> acessorios;
	
	@OneToMany(mappedBy="carro")
	private List<Aluguel> alugueis;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Carro other = (Carro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro [codigo=" + codigo + ", placa=" + placa + ", cor=" + cor + ", valorDiaria=" + valorDiaria
				+ ", modeloCarro=" + modeloCarro + ", acessorios=" + acessorios + "]";
	}

}
