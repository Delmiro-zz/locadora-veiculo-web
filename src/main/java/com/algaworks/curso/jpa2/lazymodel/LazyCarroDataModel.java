package com.algaworks.curso.jpa2.lazymodel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.CarroService;

public class LazyCarroDataModel extends LazyDataModel<Carro> implements Serializable {

	private static final long serialVersionUID = 1L;

	private CarroService carroService;

	public LazyCarroDataModel(CarroService carroService) {
		this.carroService = carroService;
	}

	@Override
	public List<Carro> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
		List<Carro> carros = this.carroService.buscarCarrosComPaginacao(first, pageSize);

		this.setRowCount(this.carroService.quantidadeDeCarroNoBanco().intValue());

		return carros;
	}

}
