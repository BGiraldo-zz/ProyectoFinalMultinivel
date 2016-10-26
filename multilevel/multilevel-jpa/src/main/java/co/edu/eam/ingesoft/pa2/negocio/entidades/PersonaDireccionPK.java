package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class PersonaDireccionPK implements Serializable{

	private int persona;
	
	private int direccion;

	/**
	 * @param persona
	 * @param direccion
	 */
	public PersonaDireccionPK(int persona, int direccion) {
		this.persona = persona;
		this.direccion = direccion;
	}

	
	public PersonaDireccionPK() {

	}


	/**
	 * @return the persona
	 */
	public int getPersona() {
		return persona;
	}


	/**
	 * @param persona the persona to set
	 */
	public void setPersona(int persona) {
		this.persona = persona;
	}


	/**
	 * @return the direccion
	 */
	public int getDireccion() {
		return direccion;
	}


	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + direccion;
		result = prime * result + persona;
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
		PersonaDireccionPK other = (PersonaDireccionPK) obj;
		if (direccion != other.direccion)
			return false;
		if (persona != other.persona)
			return false;
		return true;
	}
	
	
	
	
	
}
