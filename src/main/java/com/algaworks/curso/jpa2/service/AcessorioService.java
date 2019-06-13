package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import com.algaworks.curso.jpa2.dao.AcessorioDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioDao acessorioDao;

	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException {
		if (acessorio.getDescricao() == null || acessorio.getDescricao().trim().equals("")) {
			throw new NegocioException("Necessário informar a descrição do Acessório.");
		}
		this.acessorioDao.salvar(acessorio);
	}

	@Transactional
	public void excluir(Acessorio acessorioSelecionado) {
		this.acessorioDao.excluir(acessorioSelecionado);
	}

	public List<Acessorio> buscarTodos() {
		return this.acessorioDao.buscarTodos();
	}

}
