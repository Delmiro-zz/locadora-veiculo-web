package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.AcessorioService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAcessorioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Acessorio> acessorios;

	@Inject
	private AcessorioService acessorioService;

	private Acessorio acessorioSelecionado;

	@PostConstruct
	public void init() {
		this.acessorios = this.acessorioService.buscarTodos();
	}

	public void excluir() {
		try {
			acessorioService.excluir(acessorioSelecionado);
			this.acessorios.remove(acessorioSelecionado);
			FacesUtil.addSuccessMessage("Acessorio " + acessorioSelecionado.getDescricao() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}

}
