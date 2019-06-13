package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ModeloCarroDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(ModeloCarro modeloCarro) {
		manager.merge(modeloCarro);
	}

	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return manager.find(ModeloCarro.class, codigo);
	}

	public void excluir(ModeloCarro modeloCarroSelecionado) {
		ModeloCarro modeloCarroBanco = manager.find(ModeloCarro.class, modeloCarroSelecionado.getCodigo());
		manager.remove(modeloCarroBanco);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		return manager.createQuery("from ModeloCarro").getResultList();
	}
}
