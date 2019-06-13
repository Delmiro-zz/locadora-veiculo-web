package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

public class FabricanteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.merge(fabricante);
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return manager.find(Fabricante.class, codigo);
	}

	public void excluir(Fabricante fabricanteSelecionado) {
		Fabricante fabricanteBanco = manager.find(Fabricante.class, fabricanteSelecionado.getCodigo());
		manager.remove(fabricanteBanco);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante").getResultList();
	}

}
