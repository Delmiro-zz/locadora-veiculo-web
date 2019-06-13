package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.AcessorioService;
import com.algaworks.curso.jpa2.service.CarroService;
import com.algaworks.curso.jpa2.service.ModeloCarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Carro carro;

	private List<ModeloCarro> modelosCarros;

	private List<Acessorio> acessorios;

	@Inject
	private CarroService carroService;

	@Inject
	private AcessorioService acessorioService;

	@Inject
	private ModeloCarroService modeloCarroService;

	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.acessorios = acessorioService.buscarTodos();
		this.modelosCarros = this.modeloCarroService.buscarTodos();
	}

	public void salvar() {
		try {
			this.carroService.salvar(carro);
			FacesUtil.addSuccessMessage("Carro salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Erro desconhecido. Contatar o administrador");
		}

		this.limpar();
	}

	public void limpar() {
		this.carro = new Carro();
		this.carro.setAcessorios(new ArrayList<Acessorio>());
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public List<ModeloCarro> getModelosCarros() {
		return modelosCarros;
	}

}
