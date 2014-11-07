package sah.telefone;

import java.io.Serializable;

import javax.persistence.*;

import sah.pessoa.Pessoa;

@Entity
@SequenceGenerator(name = "telefoneSequence", sequenceName = "telefone_id_seq")
public class Telefone implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1348085948436048015L;

	public Telefone(){}
	
	public Telefone(String numero){
		this.numero = numero;
	}

	@Id
	@GeneratedValue(generator = "telefoneSequence")
	private Long id;
	
	private String numero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpessoa")
	private Pessoa idpessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Pessoa idpessoa) {
		this.idpessoa = idpessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idpessoa == null) ? 0 : idpessoa.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idpessoa == null) {
			if (other.idpessoa != null)
				return false;
		} else if (!idpessoa.equals(other.idpessoa))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	
	

	/*
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idpessoa")
	private Pessoa pessoa; */
	
	/*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idpessoa")
	private Pessoa idpessoa;*/

	
	
	
}
