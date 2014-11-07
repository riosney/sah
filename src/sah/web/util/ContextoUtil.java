package sah.web.util;

import javax.faces.context.*;
import javax.servlet.http.HttpSession;
import sah.web.ContextoBean;

/*
 * Classe responsável para obter alguma informação do contexto do usuário
 * Sendo necessário executar apenas:
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
