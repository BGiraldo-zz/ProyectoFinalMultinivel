package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSONA_DIRECCIONES")
@IdClass(PersonaDireccionPK.class)
public class PersonaDireccion implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="PERSONA_ID", nullable=false)
	private Persona persona;
	
	@Id
	@ManyToOne
	@JoinColumn(name="DIRECCION_ID", nullable = false)
	private Direccion direccion;

	/**
	 * @param persona
	 * @param direccion
	 */
	public PersonaDireccion(Persona persona, Direccion direccion) {
		this.persona = persona;
		this.direccion = direccion;
	}

	/**
	 * 
	 */
	public PersonaDireccion() {
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	
	
	
}
