package sah.tipoRelacionamentoFamilia;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tipo_relacionamento_familia")
@SequenceGenerator(name = "tipoRelacionamentoFamiliaSequence", sequenceName = "tipo_relacionamento_familia_id_seq")
public class TipoRelacionamentoFamilia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5934128024291466879L;

	@Id
	@GeneratedValue(generator = "tipoRelacionamentoFamiliaSequence")
	private Long id;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		TipoRelacionamentoFamilia other = (TipoRelacionamentoFamilia) obj;
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
		return true;
	}

}
