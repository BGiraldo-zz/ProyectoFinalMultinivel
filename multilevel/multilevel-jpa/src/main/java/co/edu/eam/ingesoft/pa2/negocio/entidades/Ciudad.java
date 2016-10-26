package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CIUDADES")
public class Ciudad implements Serializable{

	@Id
	@Column(name="CIUDAD_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="DEPARTAMENTO_ID", nullable=false)
	private Departamento departamento;
	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;

	/**
	 * @param id
	 * @param departamento
	 * @param nombre
	 */
	public Ciudad(int id, Departamento departamento, String nombre) {
		this.id = id;
		this.departamento = departamento;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public Ciudad() {
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
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
