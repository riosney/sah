package sah.web.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import sah.telefone.*;

@FacesConverter("telefoneConverter")
public class TelefoneConverter implements Converter{
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Telefone telefone = (Telefone) value;
			return telefone.getId().toString();
		}
		return null;
	}
	
	@Override    
    public Object getAsObject(FacesContext context, UIComponent component,    
            String value) {    
		if (value != null && value.trim().length() > 0) {
			Long id = Long.valueOf(value);
			try {
				TelefoneRN telefoneRN = new TelefoneRN();
				return telefoneRN.carregar(id);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar telefone de id "
						+ value + ". " + e.getMessage());
			}
		}
		return null; 
    }

}
