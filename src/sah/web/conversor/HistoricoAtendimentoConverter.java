package sah.web.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import sah.historicoAtendimento.*;

//Convert chamado sempre que for um atributo da classe
@FacesConverter(forClass = HistoricoAtendimento.class)
public class HistoricoAtendimentoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value != null && value.trim().length() > 0) {
			Long id = Long.valueOf(value);
			try {
				HistoricoAtendimentoRN historicoAtendimentoRN = new HistoricoAtendimentoRN();
				return historicoAtendimentoRN.carregar(id);
			} catch (Exception e) {
				throw new ConverterException(
						"Não foi possível encontrar o Atendimento de id"
								+ value + ". " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			HistoricoAtendimento historicoAtendimento = (HistoricoAtendimento) value;
			return historicoAtendimento.getId().toString();
		}
		return null;
	}

}
