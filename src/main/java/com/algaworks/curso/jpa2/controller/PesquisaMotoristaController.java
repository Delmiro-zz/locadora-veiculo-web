package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.MotoristaService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMotoristaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Motorista> motoristas;

	private Motorista motoristaSelecionado;

	@Inject
	private MotoristaService motoristaService;

	@PostConstruct
	public void init() {
		this.motoristas = this.motoristaService.buscarTodos();
	}

	public void excluir() {
		try {
			this.motoristaService.excluir(motoristaSelecionado);
			this.motoristas.remove(motoristaSelecionado);
			FacesUtil.addSuccessMessage("Motorista removido com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addSuccessMessage("Erro ao remover o Motorista.");
		}
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}

	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}

}
