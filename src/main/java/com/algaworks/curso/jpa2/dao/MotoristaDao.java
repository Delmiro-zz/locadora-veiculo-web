package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.algaworks.curso.jpa2.modelo.Motorista;

public class MotoristaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Motorista motorista) {
		manager.merge(motorista);
	}

	public Motorista buscarPeloCodigo(Long codigo) {
		return manager.find(Motorista.class, codigo);
	}

	public void excluir(Motorista motoristaSelecionado) {
		Motorista motoristaBanco = manager.find(Motorista.class, motoristaSelecionado.getCodigo());
		manager.remove(motoristaBanco);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Motorista> buscarTodos() {
		return manager.createQuery("from Motorista").getResultList();
	}

}
