package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AluguelDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AluguelService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelDao aluguelDao;

	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException {
		if (aluguel.getCarro() == null || aluguel.getCarro().getModeloCarro().getDescricao().trim().equals("")) {
			throw new NegocioException("É necessário informar o carro a ser alugado.");
		}
		this.aluguelDao.salvar(aluguel);
	}

	@Transactional
	public void excluir(Aluguel aluguelSelecionado) throws NegocioException{
		if(aluguelSelecionado == null) {
			throw new NegocioException("Não há aluguel selecionado para exclusão");
		}
		this.aluguelDao.excluir(aluguelSelecionado);
	}
	
	public List<Aluguel> buscarTodos() {
		return this.aluguelDao.buscarTodos();
	}

	public List<Aluguel> buscarPorDataDeEntregaEModeloCarro(Date dataEntrega, ModeloCarro modeloCarro) {
		return this.aluguelDao.buscarPorDataDeEntregaEModeloCarro(dataEntrega, modeloCarro);
	}
}
