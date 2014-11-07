package sah.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;

import sah.util.HibernateUtil;

public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sf;

	/*
	 * Executa quando o aplicativo entra no ar. 
	 * Classe SessionFactory cria todas
	 * as sessões do Hibernate, a cada requisição.
	 */
	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}
	
	// Executa quando o aplicativo é desativado ou servidor é retirado do ar
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws ServletException {
		try {
			this.sf.getCurrentSession().beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			this.sf.getCurrentSession().getTransaction().commit(); // transação bem-sucedida
			this.sf.getCurrentSession().close();
		} catch (Throwable ex) {
			try {
				if (this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback(); // desfaz a transação corrente
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException();
		}
	}
	
}
