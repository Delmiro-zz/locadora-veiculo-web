package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;

	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null && fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do Fabricante é obrigatório.");
		}
		this.fabricanteDao.salvar(fabricante);
	}

	@Transactional
	public void excluir(Fabricante fabricanteSelecionado) throws NegocioException {
		fabricanteDao.excluir(fabricanteSelecionado);
	}

	public List<Fabricante> buscarTodos() {
		return fabricanteDao.buscarTodos();
	}

}
