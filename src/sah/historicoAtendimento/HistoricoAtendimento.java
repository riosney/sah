package sah.historicoAtendimento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import sah.pessoa.Pessoa;
import sah.setor.Setor;
import sah.usuario.Usuario;

@Entity
@Table(name = "historico_atendimento")
@SequenceGenerator(name = "historicoAtendimentoSequence", sequenceName = "historico_atendimento_id_seq")
public class HistoricoAtendimento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2762393505081839960L;

	@Id
	@GeneratedValue(generator = "historicoAtendimentoSequence")
	private Long id;
	
	@Column(name = "dataatendimento", nullable = false, updatable = false)
	private Date dataAtendimento;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsetor")
	private Setor setor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpessoa")
	private Pessoa pessoaatendimento;
	
	@Column(name = "assuntopredefinidos")
	private String assuntopredefinidos;
	
	@Column(name = "assuntooutros")
	private String assuntooutros;
	
	@Column(name = "observacoes")
	private String observacoes;
	
	@Column(name = "estadoatendimento")
	private String estadoAtendimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public Pessoa getPessoaatendimento() {
		return pessoaatendimento;
	}

	public void setPessoaatendimento(Pessoa pessoaatendimento) {
		this.pessoaatendimento = pessoaatendimento;
	}

	public String getAssuntopredefinidos() {
		return assuntopredefinidos;
	}

	public void setAssuntopredefinidos(String assuntopredefinidos) {
		this.assuntopredefinidos = assuntopredefinidos;
	}

	public String getAssuntooutros() {
		return assuntooutros;
	}

	public void setAssuntooutros(String assuntooutros) {
		this.assuntooutros = assuntooutros;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}	

	public String getEstadoAtendimento() {
		return estadoAtendimento;
	}

	public void setEstadoAtendimento(String estadoAtendimento) {
		this.estadoAtendimento = estadoAtendimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assuntooutros == null) ? 0 : assuntooutros.hashCode());
		result = prime
				* result
				+ ((assuntopredefinidos == null) ? 0 : assuntopredefinidos
						.hashCode());
		result = prime * result
				+ ((dataAtendimento == null) ? 0 : dataAtendimento.hashCode());
		result = prime
				* result
				+ ((estadoAtendimento == null) ? 0 : estadoAtendimento
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime
				* result
				+ ((pessoaatendimento == null) ? 0 : pessoaatendimento
						.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		HistoricoAtendimento other = (HistoricoAtendimento) obj;
		if (assuntooutros == null) {
			if (other.assuntooutros != null)
				return false;
		} else if (!assuntooutros.equals(other.assuntooutros))
			return false;
		if (assuntopredefinidos == null) {
			if (other.assuntopredefinidos != null)
				return false;
		} else if (!assuntopredefinidos.equals(other.assuntopredefinidos))
			return false;
		if (dataAtendimento == null) {
			if (other.dataAtendimento != null)
				return false;
		} else if (!dataAtendimento.equals(other.dataAtendimento))
			return false;
		if (estadoAtendimento == null) {
			if (other.estadoAtendimento != null)
				return false;
		} else if (!estadoAtendimento.equals(other.estadoAtendimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (pessoaatendimento == null) {
			if (other.pessoaatendimento != null)
				return false;
		} else if (!pessoaatendimento.equals(other.pessoaatendimento))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	

}
