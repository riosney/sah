package sah.web.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import sah.pessoa.*;

@FacesConverter(forClass = Pessoa.class) // Convert chamado sempre que for um atributo da classe
public class PessoaConverter implements Converter{	
	
	@Override    
    public Object getAsObject(FacesContext context, UIComponent component,    
            String value) {    
		if (value != null && value.trim().length() > 0) {
			Long id = Long.valueOf(value);
			try {
				PessoaRN pessoaRN = new PessoaRN();
				return pessoaRN.carregar(id);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar a pessoa de id "
						+ value + ". " + e.getMessage());
			}
		}
		return null; 
    }
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getId().toString();
		}
		return null;
	}


}
