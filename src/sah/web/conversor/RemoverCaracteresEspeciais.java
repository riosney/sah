package sah.web.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="removerCaracteres") 
public class RemoverCaracteresEspeciais implements Converter{
	
	// Remover caracteres especiais
	@Override  
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {  
        if(valor != null || valor != "") {  
        	String[] caracteresEspeciais = {"\\.", ",", "-", ":", "\\(", "\\)", "ª", "\\|", "\\\\", "°"};
            for (int i = 0; i < caracteresEspeciais.length; i++) {  
            	valor = valor.toString().replaceAll(caracteresEspeciais[i], "");  
            } 
        }  
        return valor;  
    }  
  
    @Override  
    public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {  
        return valor.toString();  
    }

}
