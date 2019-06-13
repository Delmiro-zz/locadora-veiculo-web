package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.algaworks.curso.jpa2.dao.ModeloCarroDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDao modeloCarroDao;

	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException {
		if (modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")) {
			throw new NegocioException("É necessário informar o campo descrição.");
		}

		if (modeloCarro.getFabricante() == null) {
			throw new NegocioException("É necessário informar o Fabricante do Modelo.");
		}
		this.modeloCarroDao.salvar(modeloCarro);
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarroSelecionado) {
		this.modeloCarroDao.excluir(modeloCarroSelecionado);
	}

	public List<ModeloCarro> buscarTodos() {
		return this.modeloCarroDao.buscarTodos();
	}
}
