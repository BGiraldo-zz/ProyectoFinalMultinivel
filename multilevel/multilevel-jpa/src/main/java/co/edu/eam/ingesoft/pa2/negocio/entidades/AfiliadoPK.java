package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class AfiliadoPK implements Serializable{

	// Representa el id del representante
	private int id;
	
	private int representante;

	/**
	 * @param id
	 * @param representante
	 */
	public AfiliadoPK(int id, int representante) {
		this.id = id;
		this.representante = representante;
	}

	/**
	 * 
	 */
	public AfiliadoPK() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the representante
	 */
	public int getRepresentante() {
		return representante;
	}

	/**
	 * @param representante the representante to set
	 */
	public void setRepresentante(int representante) {
		this.representante = representante;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + representante;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AfiliadoPK other = (AfiliadoPK) obj;
		if (id != other.id)
			return false;
		if (representante != other.representante)
			return false;
		return true;
	}

	
	
	
	
}
