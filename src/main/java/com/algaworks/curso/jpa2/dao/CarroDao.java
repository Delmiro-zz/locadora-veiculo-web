package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.algaworks.curso.jpa2.modelo.Carro;

public class CarroDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Carro carro) {
		manager.merge(carro);
	}

	public void excluir(Carro carroSelecionado) {
		Carro carroBanco = manager.find(Carro.class, carroSelecionado.getCodigo());
		manager.remove(carroBanco);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos() {
		return manager.createQuery("from tb_carro").getResultList();
	}

	public Carro buscarPeloCodigo(Long codigo) {
		return manager.find(Carro.class, codigo);
	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return (Carro) manager.createQuery("select c from tb_carro c JOIN c.acessorios a where c.codigo = ?")
				.setParameter(1, codigo)
				.getSingleResult();
	}
}
