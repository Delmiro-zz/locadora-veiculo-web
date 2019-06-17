package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.CarroDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDao carroDao;

	@Transactional
	public void salvar(Carro carro) throws NegocioException {
		if (carro.getPlaca() == null || carro.getPlaca().trim().equals("")) {
			throw new NegocioException("É necessário informar a placa do Carro.");
		}
		this.carroDao.salvar(carro);
	}

	@Transactional
	public void excluir(Carro carroSelecionado) throws NegocioException {
		this.carroDao.excluir(carroSelecionado);
	}

	public List<Carro> buscarTodos() {
		return this.carroDao.buscarTodos();
	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return this.carroDao.buscarCarroComAcessorios(codigo);
	}

	public List<Carro> buscarCarrosComPaginacao(int first, int pageSize) {
		return this.carroDao.buscarCarroComPaginacao(first, pageSize);
	}

	public Long quantidadeDeCarroNoBanco() {
		return this.carroDao.quantidadeDeCarroNoBanco();
	}

}
