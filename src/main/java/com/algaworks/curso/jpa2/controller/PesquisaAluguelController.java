package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.AluguelService;
import com.algaworks.curso.jpa2.service.ModeloCarroService;

@Named
@ViewScoped
public class PesquisaAluguelController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelService aluguelService;

	@Inject
	private ModeloCarroService modeloCarroService;

	private List<Aluguel> aluguels;

	private List<ModeloCarro> modeloCarros;

	private Aluguel aluguel;

	private Carro carro;

	@PostConstruct
	public void init() {
		this.aluguel = new Aluguel();
		this.carro = new Carro();
		this.modeloCarros = modeloCarroService.buscarTodos();
	}
	
	public void pesquisar() {
		this.aluguels = aluguelService.buscarPorDataDeEntregaEModeloCarro(this.aluguel.getDataEntrega(), this.carro.getModeloCarro());
	}

	public List<Aluguel> getAluguels() {
		return aluguels;
	}

	public void setAluguels(List<Aluguel> aluguels) {
		this.aluguels = aluguels;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<ModeloCarro> getModeloCarros() {
		return modeloCarros;
	}

	public void setModeloCarros(List<ModeloCarro> modeloCarros) {
		this.modeloCarros = modeloCarros;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
