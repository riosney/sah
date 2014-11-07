package sah.web.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import sah.tipoDeficienciaFisica.*;

//Convert chamado sempre que for um atributo da classe
@FacesConverter(value = "tipoDfConverter", forClass = TipoDeficienciaFisica.class)
public class TipoDeficienciaFisicaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Long id = Long.valueOf(value);
			try {
				TipoDeficienciaFisicaRN tipoDeficienciaFisicaRN = new TipoDeficienciaFisicaRN();
				return tipoDeficienciaFisicaRN.carregar(id);
			} catch (Exception e) {
				throw new ConverterException(
						"Não foi possível encontrar o Tipo Deficiência Física de id"
								+ value + ". " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TipoDeficienciaFisica tipoDeficienciaFisica = (TipoDeficienciaFisica) value;
			return tipoDeficienciaFisica.getId().toString();
		}
		return "";
	}

}
