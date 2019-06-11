package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

public class FabricanteDao implements Serializable {

	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return null;
	}

}
