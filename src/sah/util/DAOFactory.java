package sah.util;

import sah.usuario.*;
import sah.bairro.BairroDAO;
import sah.bairro.BairroDAOHibernate;
import sah.cidade.*;
import sah.estado.EstadoDAO;
import sah.estado.EstadoDAOHibernate;
import sah.historicoAtendimento.HistoricoAtendimentoDAO;
import sah.historicoAtendimento.HistoricoAtendimentoDAOHibernate;
import sah.pessoa.*;
import sah.profissao.ProfissaoDAO;
import sah.profissao.ProfissaoDAOHibernate;
import sah.projeto.ProjetoDAO;
import sah.projeto.ProjetoDAOHibernate;
import sah.setor.SetorDAO;
import sah.setor.SetorDAOHibernate;
import sah.tipoDeficienciaFisica.TipoDeficienciaFisicaDAO;
import sah.tipoDeficienciaFisica.TipoDeficienciaFisicaDAOHibernate;
import sah.tipoGrauEscolaridade.*;
import sah.telefone.*;

public class DAOFactory {
	
	public static UsuarioDAO criarUsuarioDAO(){
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static PessoaDAO criarPessoaDAO(){
		PessoaDAOHibernate pessoaDAO = new PessoaDAOHibernate();
		pessoaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pessoaDAO;
	}
	
	public static TipoGrauEscolaridadeDAO criarTipoGrauEscolaridadeDAO(){
		TipoGrauEscolaridadeDAOHibernate tipoGrauEscolaridadeDAO = new TipoGrauEscolaridadeDAOHibernate();
		tipoGrauEscolaridadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return tipoGrauEscolaridadeDAO;
	}
	
	public static TelefoneDAO criarTelefoneDAO(){
		TelefoneDAOHibernate telefoneDAO = new TelefoneDAOHibernate();
		telefoneDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return telefoneDAO;
	}

	public static BairroDAO criarBairroDAO() {
		BairroDAOHibernate bairroDAO = new BairroDAOHibernate();
		bairroDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return bairroDAO;
	}
	
	public static CidadeDAO criarCidadeDAO() {
		CidadeDAOHibernate cidadeDAO = new CidadeDAOHibernate();
		cidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return cidadeDAO;
	}
	
	public static EstadoDAO criarEstadoDAO() {
		EstadoDAOHibernate estadoDAO = new EstadoDAOHibernate();
		estadoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return estadoDAO;
	}

	public static TipoDeficienciaFisicaDAO criarTipoDeficienciaFisicaDAO() {
		TipoDeficienciaFisicaDAOHibernate tipoDeficienciaFisicaDAO = new TipoDeficienciaFisicaDAOHibernate();
		tipoDeficienciaFisicaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return tipoDeficienciaFisicaDAO;
	}
	
	public static SetorDAO criarSetorDAO() {
		SetorDAOHibernate setorDAO = new SetorDAOHibernate();
		setorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return setorDAO;
	}
	
	public static HistoricoAtendimentoDAO criarHistoricoAtendimentoDAO(){
		HistoricoAtendimentoDAOHibernate historicoAtendimentoDAO = new HistoricoAtendimentoDAOHibernate();
		historicoAtendimentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return historicoAtendimentoDAO;
	}
	
	public static ProjetoDAO criarProjetoDAO(){
		ProjetoDAOHibernate projetoDAO = new ProjetoDAOHibernate();
		projetoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return projetoDAO;
	}
	
	public static ProfissaoDAO criarProfissaoDAO(){
		ProfissaoDAOHibernate profissaoDAO = new ProfissaoDAOHibernate();
		profissaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return profissaoDAO;
	}

}
