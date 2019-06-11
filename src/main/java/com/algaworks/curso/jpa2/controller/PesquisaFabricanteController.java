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
import com.algaworks.curso.jpa2.service.FabricanteService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteService fabricanteService;

	private List<Fabricante> fabricantes = new ArrayList<>();

	private Fabricante fabricanteSelecionado;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteService.buscarTodos();
	}

	public void excluir() {
		try {
			fabricanteService.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante " + fabricanteSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

}
