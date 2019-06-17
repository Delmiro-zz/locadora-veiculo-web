package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

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
public class CadastroMotoristaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Motorista motorista;

	@Inject
	private MotoristaService motoristaService;

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void salvar() {
		try {
			this.motoristaService.salvar(motorista);
			FacesUtil.addSuccessMessage("Motorista cadastrado com sucesso.");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro ao salvar o Modelo de Carro.");
		}
	}

	private void limpar() {
		this.motorista = new Motorista();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

}
