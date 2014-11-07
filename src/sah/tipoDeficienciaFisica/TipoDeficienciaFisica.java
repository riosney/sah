package sah.tipoDeficienciaFisica;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "tipo_deficiencia_fisica")
@SequenceGenerator(name = "defFisicaSequence", sequenceName = "tipo_deficiencia_fisica_id_seq")
public class TipoDeficienciaFisica implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5831465061090834089L;

	@Id
	@GeneratedValue(generator = "defFisicaSequence")
	private Long id;
	
	@Column(name = "dstipodeficienciafisica")
	private String dstipodeficienciafisica;		
	
	/*
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "deficiencia_fisica",
	joinColumns = {@JoinColumn(name = "idtipodeficiencia", nullable = false,
	updatable = false)}, inverseJoinColumns = {
	@JoinColumn(name = "idpessoa", nullable = false, updatable = false)})
	private List<Pessoa> idPessoas;
	*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDstipodeficienciafisica() {
		return dstipodeficienciafisica;
	}

	public void setDstipodeficienciafisica(String dstipodeficienciafisica) {
		this.dstipodeficienciafisica = dstipodeficienciafisica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dstipodeficienciafisica == null) ? 0
						: dstipodeficienciafisica.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TipoDeficienciaFisica other = (TipoDeficienciaFisica) obj;
		if (dstipodeficienciafisica == null) {
			if (other.dstipodeficienciafisica != null)
				return false;
		} else if (!dstipodeficienciafisica
				.equals(other.dstipodeficienciafisica))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
