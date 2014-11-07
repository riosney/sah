package sah.web.util;

import javax.faces.context.*;
import javax.servlet.http.HttpSession;
import sah.web.ContextoBean;

/*
 * Classe respons�vel para obter alguma informa��o do contexto do usu�rio
 * Sendo necess�rio executar apenas:
 * ContextoBean contextoBean = new ContextoUtil.getContextoBean();
 */
public class ContextoUtil {
	
	public static ContextoBean getContextoBean(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		HttpSession session = (HttpSession) external.getSession(true);
		ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
		return contextoBean;
	}

}
