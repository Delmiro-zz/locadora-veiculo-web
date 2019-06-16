package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.CarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCarroController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Carro> carros;

	private Carro carroSelecionado;

	@Inject
	private CarroService carroService;

	@PostConstruct
	public void init() {
		this.carros = carroService.buscarTodos();
	}

	public void excluir() {
		try {
			carroService.excluir(carroSelecionado);
			this.carros.remove(carroSelecionado);
			FacesUtil.addSuccessMessage(
					"Carro " + carroSelecionado.getModeloCarro().getDescricao() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscarCarroComAcessorios(){
		this.carroSelecionado = carroService.buscarCarroComAcessorios(carroSelecionado.getCodigo());
	}
	
	public List<Carro> getCarros() {
		return carros;
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

}
