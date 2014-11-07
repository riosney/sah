package sah.bairro;

import java.io.Serializable;
import javax.persistence.*;
import sah.regional.Regional;

@Entity
@SequenceGenerator(name = "bairroSequence", sequenceName = "bairro_id_seq")
public class Bairro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8256798083972198856L;

	@Id
	@GeneratedValue(generator = "bairroSequence")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idregional")
	private Regional regional;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
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
		result = prime * result
				+ ((regional == null) ? 0 : regional.hashCode());
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
		Bairro other = (Bairro) obj;
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
		if (regional == null) {
			if (other.regional != null)
				return false;
		} else if (!regional.equals(other.regional))
			return false;
		return true;
	}

}
