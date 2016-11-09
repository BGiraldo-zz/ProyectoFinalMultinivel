package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class CuotaPK implements Serializable{

	private int credito;
	
	private int id;

	public CuotaPK(int credito, int id) {
		super();
		this.credito = credito;
		this.id = id;
	}

	public CuotaPK() {
		
	}

	/**
	 * @return the credito
	 */
	public int getCredito() {
		return credito;
	}

	/**
	 * @param credito the credito to set
	 */
	public void setCredito(int credito) {
		this.credito = credito;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credito;
		result = prime * result + id;
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
		CuotaPK other = (CuotaPK) obj;
		if (credito != other.credito)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
}
