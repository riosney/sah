package sah.pessoa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

import sah.bairro.Bairro;
import sah.historicoAtendimento.HistoricoAtendimento;
import sah.profissao.Profissao;
import sah.telefone.Telefone;
import sah.tipoGrauEscolaridade.TipoGrauEscolaridade;
import sah.tipoEstadoCivil.TipoEstadoCivil;
import sah.tipoFaixaEtaria.TipoFaixaEtaria;
import sah.tipoRelacionamentoFamilia.TipoRelacionamentoFamilia;
import sah.tipoDeficienciaFisica.TipoDeficienciaFisica;

@Entity
@SequenceGenerator(name = "pessoaSequence", sequenceName = "pessoa_id_seq")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8502872590407131750L;

	public Pessoa(){}
	
	public Pessoa(String nome, String sexo, Date dtNascimento,String rg,
			String orgaoExpeditor,String cpf,String nomePai,String nomeMae,Date dataCadastro){
		this.nome = nome;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
		this.rg = rg;
		this.orgaoExpeditor = orgaoExpeditor;
		this.cpf = cpf;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.dataCadastro = dataCadastro;
	}
	
	@Id
	@GeneratedValue(generator = "pessoaSequence")
	private Long id;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", nullable = false)
	@ForeignKey(name = "fk_pessoa_usuario")
	private Usuario usuario;*/

	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "dtnascimento")
	private Date dtNascimento;

	@Column(name = "rg")
	private String rg;

	@Column(name = "orgaoexpeditor")
	private String orgaoExpeditor;

	@Column(name = "cpf", unique=true)
	private String cpf;

	@Column(name = "nomepai")
	private String nomePai;

	@Column(name = "nomemae")
	private String nomeMae;

	@Column(name = "datacadastro", nullable = false, updatable = false)
	private Date dataCadastro;

	@ManyToOne
	@JoinColumn(name = "idgrauescolaridade")
	private TipoGrauEscolaridade tipoGrauEscolaridade; 

	@ManyToOne
	@JoinColumn(name = "idbairro")
	private Bairro bairro;
	
	@ManyToOne
	@JoinColumn(name = "idtiporelacionamentofamilia")
	private TipoRelacionamentoFamilia tipoRelacionamentoFamilia;

	@ManyToOne
	@JoinColumn(name = "idfaixaetaria")
	private TipoFaixaEtaria tipoFaixaEtaria;

	@ManyToOne
	@JoinColumn(name = "idestadocivil")
	private TipoEstadoCivil tipoEstadoCivil;
	
	@ManyToOne
	@JoinColumn(name = "idprofissao")
	private Profissao profissao;
	
	/**
	 * Atributo tipoDeficienciaFisica
	 * <p>Esse atributo é o dono do relacionamento ManyToMany
	 * com o atribuito pessoas da classe TipoDeficienciaFisica</p>
	 * @see TipoDeficienciaFisica
	 * @author Riosney Santos
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "deficiencia_fisica", joinColumns = {@JoinColumn(name = "idpessoa")},
	inverseJoinColumns = {@JoinColumn(name = "idtipodeficiencia")})
	private Set<TipoDeficienciaFisica> tipoDeficienciaFisicas = new HashSet<TipoDeficienciaFisica>();	
	
	// orphanRemoval=true remoção de valores entre relacionamento da entidade Telefone e Pessoa
	@OneToMany(mappedBy = "idpessoa", fetch = FetchType.LAZY, orphanRemoval=true)
	private List<Telefone> telefones;
	
	@OneToMany(mappedBy = "pessoaatendimento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy("dataAtendimento DESC")
	private List<HistoricoAtendimento> atendimentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoGrauEscolaridade getTipoGrauEscolaridade() {
		return tipoGrauEscolaridade;
	}

	public void setTipoGrauEscolaridade(TipoGrauEscolaridade tipoGrauEscolaridade) {
		this.tipoGrauEscolaridade = tipoGrauEscolaridade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public TipoRelacionamentoFamilia getTipoRelacionamentoFamilia() {
		return tipoRelacionamentoFamilia;
	}

	public void setTipoRelacionamentoFamilia(
			TipoRelacionamentoFamilia tipoRelacionamentoFamilia) {
		this.tipoRelacionamentoFamilia = tipoRelacionamentoFamilia;
	}

	public TipoFaixaEtaria getTipoFaixaEtaria() {
		return tipoFaixaEtaria;
	}

	public void setTipoFaixaEtaria(TipoFaixaEtaria tipoFaixaEtaria) {
		this.tipoFaixaEtaria = tipoFaixaEtaria;
	}

	public TipoEstadoCivil getTipoEstadoCivil() {
		return tipoEstadoCivil;
	}

	public void setTipoEstadoCivil(TipoEstadoCivil tipoEstadoCivil) {
		this.tipoEstadoCivil = tipoEstadoCivil;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public Set<TipoDeficienciaFisica> getTipoDeficienciaFisicas() {
		return tipoDeficienciaFisicas;
	}

	public void setTipoDeficienciaFisicas(
			Set<TipoDeficienciaFisica> tipoDeficienciaFisicas) {
		this.tipoDeficienciaFisicas = tipoDeficienciaFisicas;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}	

	public List<HistoricoAtendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<HistoricoAtendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atendimentos == null) ? 0 : atendimentos.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePai == null) ? 0 : nomePai.hashCode());
		result = prime * result
				+ ((orgaoExpeditor == null) ? 0 : orgaoExpeditor.hashCode());
		result = prime * result
				+ ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((telefones == null) ? 0 : telefones.hashCode());
		result = prime
				* result
				+ ((tipoDeficienciaFisicas == null) ? 0
						: tipoDeficienciaFisicas.hashCode());
		result = prime * result
				+ ((tipoEstadoCivil == null) ? 0 : tipoEstadoCivil.hashCode());
		result = prime * result
				+ ((tipoFaixaEtaria == null) ? 0 : tipoFaixaEtaria.hashCode());
		result = prime
				* result
				+ ((tipoGrauEscolaridade == null) ? 0 : tipoGrauEscolaridade
						.hashCode());
		result = prime
				* result
				+ ((tipoRelacionamentoFamilia == null) ? 0
						: tipoRelacionamentoFamilia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (atendimentos == null) {
			if (other.atendimentos != null)
				return false;
		} else if (!atendimentos.equals(other.atendimentos))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePai == null) {
			if (other.nomePai != null)
				return false;
		} else if (!nomePai.equals(other.nomePai))
			return false;
		if (orgaoExpeditor == null) {
			if (other.orgaoExpeditor != null)
				return false;
		} else if (!orgaoExpeditor.equals(other.orgaoExpeditor))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		if (tipoDeficienciaFisicas == null) {
			if (other.tipoDeficienciaFisicas != null)
				return false;
		} else if (!tipoDeficienciaFisicas.equals(other.tipoDeficienciaFisicas))
			return false;
		if (tipoEstadoCivil == null) {
			if (other.tipoEstadoCivil != null)
				return false;
		} else if (!tipoEstadoCivil.equals(other.tipoEstadoCivil))
			return false;
		if (tipoFaixaEtaria == null) {
			if (other.tipoFaixaEtaria != null)
				return false;
		} else if (!tipoFaixaEtaria.equals(other.tipoFaixaEtaria))
			return false;
		if (tipoGrauEscolaridade == null) {
			if (other.tipoGrauEscolaridade != null)
				return false;
		} else if (!tipoGrauEscolaridade.equals(other.tipoGrauEscolaridade))
			return false;
		if (tipoRelacionamentoFamilia == null) {
			if (other.tipoRelacionamentoFamilia != null)
				return false;
		} else if (!tipoRelacionamentoFamilia
				.equals(other.tipoRelacionamentoFamilia))
			return false;
		return true;
	}

	

	
	
}
