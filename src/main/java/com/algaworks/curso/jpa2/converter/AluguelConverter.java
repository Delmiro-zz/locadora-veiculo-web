package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.algaworks.curso.jpa2.dao.AluguelDao;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Aluguel.class)
public class AluguelConverter implements Converter {

	private AluguelDao aluguelDao;

	public AluguelConverter() {
		this.aluguelDao = CDIServiceLocator.getBean(AluguelDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluguel retorno = null;

		if (value != null) {
			retorno = this.aluguelDao.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Aluguel) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
