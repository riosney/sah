package sah.tipoDeficienciaFisica;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TipoDeficienciaFisicaDAOHibernate implements TipoDeficienciaFisicaDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(TipoDeficienciaFisica tipoDeficienciaFisica) {
		this.session.saveOrUpdate(tipoDeficienciaFisica);		
	}

	@Override
	public void excluir(TipoDeficienciaFisica tipoDeficienciaFisica) {
		this.session.delete(tipoDeficienciaFisica);		
	}

	@Override
	public TipoDeficienciaFisica carregar(Long tipoDeficienciaFisica) {
		return (TipoDeficienciaFisica) this.session.get(TipoDeficienciaFisica.class, tipoDeficienciaFisica);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDeficienciaFisica> listar() {
		return this.session.createCriteria(TipoDeficienciaFisica.class).list();
	}

	@Override
	public TipoDeficienciaFisica buscarTipoDeficienciaFisica(
			String tipoDeficienciaFisica) {
		String hql = "SELECT df FROM TipoDeficienciaFisica df WHERE df.dstipodeficienciafisica = :tipoDeficienciaFisica";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("dstipodeficienciafisica", tipoDeficienciaFisica);
		return (TipoDeficienciaFisica) consulta.uniqueResult();
	}
	
	

}
