package sah.estado;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class EstadoDAOHibernate implements EstadoDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Estado estado) {
		this.session.saveOrUpdate(estado);
	}

	@Override
	public void excluir(Estado estado) {
		this.session.delete(estado);
	}

	@Override
	public Estado carregar(Long id) {
		return (Estado) this.session.get(Estado.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listar() {
		return this.session.createCriteria(Estado.class).list();
	}

	@Override
	public Estado buscarEstado(String nome) {
		String hql = "SELECT es FROM Estado es WHERE es.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Estado) consulta.uniqueResult();
	}
	
	

}
