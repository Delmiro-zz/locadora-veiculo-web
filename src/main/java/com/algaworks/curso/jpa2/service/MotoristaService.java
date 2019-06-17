package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.MotoristaDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class MotoristaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MotoristaDao motoristaDao;

	@Transactional
	public void salvar(Motorista motorista) throws NegocioException {
		if(motorista.getNome() == null || motorista.getNome().trim().equals("")) {
			throw new NegocioException("Necessário informar o Nome do Motorista ");
		}

		if(motorista.getCpf() == null || motorista.getCpf().trim().equals("")) {
			throw new NegocioException("Necessário informar o CPF do Motorista ");
		}
		this.motoristaDao.salvar(motorista);
	}

	@Transactional
	public void excluir(Motorista motoristaSelecionado) throws NegocioException {
		if (motoristaSelecionado != null) {
			this.motoristaDao.excluir(motoristaSelecionado);
		}
	}

	public List<Motorista> buscarTodos() {
		return this.motoristaDao.buscarTodos();
	}
}
