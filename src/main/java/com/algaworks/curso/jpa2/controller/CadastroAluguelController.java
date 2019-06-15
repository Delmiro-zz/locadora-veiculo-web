package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.AluguelService;
import com.algaworks.curso.jpa2.service.CarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAluguelController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelService aluguelService;

	@Inject
	private CarroService carroService;

	private List<Carro> carros;

	private Aluguel aluguel;

	@PostConstruct
	public void init() {
		this.limpar();
		this.carros = carroService.buscarTodos();
	}

	public void salvar() {
		try {
			this.aluguelService.salvar(aluguel);
			FacesUtil.addSuccessMessage("Aluguel salvo com sucesso.");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro ao salvar um Aluguel.");
		}
	}

	public void limpar() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Carro> getCarros() {
		return carros;
	}

}
