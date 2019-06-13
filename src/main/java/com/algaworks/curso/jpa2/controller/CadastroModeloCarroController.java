package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.FabricanteService;
import com.algaworks.curso.jpa2.service.ModeloCarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloCarroController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroService modeloCarroService;

	@Inject
	private FabricanteService fabricanteService;

	private List<Fabricante> fabricantes = new ArrayList<Fabricante>();

	private ModeloCarro modeloCarro = new ModeloCarro();

	@PostConstruct
	public void init() {
		setFabricantes(fabricanteService.buscarTodos());
	}

	public void salvar() {
		try {
			this.modeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo de Carro salvo com sucesso.");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro ao salvar o Modelo de Carro.");
		}
	}

	public void limpar() {
		this.modeloCarro = new ModeloCarro();
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

}
