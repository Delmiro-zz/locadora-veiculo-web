package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Fabricante;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;

	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null && fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do Fabricante é obrigatório.");
		}
		this.fabricanteDao.salvar(fabricante);
	}

}
