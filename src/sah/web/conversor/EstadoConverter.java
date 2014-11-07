package sah.web.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import sah.estado.*;

//Convert chamado sempre que for um atributo da classe
@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value != null && value.trim().length() > 0) {
			Long id = Long.valueOf(value);
			try {
				EstadoRN estadoRN = new EstadoRN();
				return estadoRN.carregar(id);
			} catch (Exception e) {
				throw new ConverterException(
						"Não foi possível encontrar o Estado de id"
								+ value + ". " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			Estado estado = (Estado) value;
			return estado.getId().toString();
		}
		return null;
	}

}
