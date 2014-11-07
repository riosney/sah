package sah.telefone;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TelefoneDAOHibernate implements TelefoneDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Telefone telefone) {		
		this.session.saveOrUpdate(telefone);
	}

	@Override
	public void excluir(Telefone telefone) {
		this.session.delete(telefone);		
	}

	@Override
	public Telefone carregar(Long telefone) {
		return (Telefone) this.session.get(Telefone.class, telefone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Telefone> listar() {
		return this.session.createCriteria(Telefone.class).list();
	}

	@Override
	public Telefone buscarTelefone(String numero) {
		String hql = "SELECT tel FROM Telefone tel WHERE tel.numero = :numero";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("numero", numero);
		return (Telefone) consulta.uniqueResult();
	}

}
