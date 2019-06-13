package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Acessorio;

public class AcessorioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Acessorio acessorio) {
		manager.merge(acessorio);
	}

	public void excluir(Acessorio acessorioSelecionado) {
		Acessorio acessorioBanco = manager.find(Acessorio.class, acessorioSelecionado.getCodigo());
		manager.remove(acessorioBanco);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarTodos() {
		return manager.createQuery("from Acessorio").getResultList();
	}
}
