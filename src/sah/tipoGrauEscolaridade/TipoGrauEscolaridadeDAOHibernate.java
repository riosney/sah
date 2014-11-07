package sah.tipoGrauEscolaridade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TipoGrauEscolaridadeDAOHibernate implements TipoGrauEscolaridadeDAO {
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(TipoGrauEscolaridade tipoGrauEscolaridade) {
		this.session.saveOrUpdate(tipoGrauEscolaridade);
	}

	@Override
	public void excluir(TipoGrauEscolaridade tipoGrauEscolaridade) {
		this.session.delete(tipoGrauEscolaridade);
	}

	@Override
	public TipoGrauEscolaridade carregar(Long tipoGrauEscolaridade) {
		return (TipoGrauEscolaridade) this.session.get(TipoGrauEscolaridade.class, tipoGrauEscolaridade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoGrauEscolaridade> listar() {
		return this.session.createCriteria(TipoGrauEscolaridade.class).list();
	}

	@Override
	public TipoGrauEscolaridade buscarTipoGrauEscolaridade(
			String nome) {
		String hql = "SELECT ge FROM TipoGrauEscolaridade ge WHERE ge.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (TipoGrauEscolaridade) consulta.uniqueResult();
	}

}
