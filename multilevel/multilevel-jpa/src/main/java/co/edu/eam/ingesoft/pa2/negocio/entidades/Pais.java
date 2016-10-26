package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAISES")
public class Pais implements Serializable{

	@Id
	@Column(name="PAIS_ID", length=12, nullable=false)
	private int id;
	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;

	/**
	 * @param id
	 * @param nombre
	 */
	public Pais(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public Pais() {
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
