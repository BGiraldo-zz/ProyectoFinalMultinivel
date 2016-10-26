package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento implements Serializable{

	@Id
	@Column(name="DEPARTAMENTO_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="PAIS_ID", nullable=false)
	private Pais pais;

	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;


	/**
	 * @param id
	 * @param pais
	 * @param nombre
	 */
	public Departamento(int id, Pais pais, String nombre) {
		this.id = id;
		this.pais = pais;
		this.nombre = nombre;
	}


	/**
	 * 
	 */
	public Departamento() {
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
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}


	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
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
