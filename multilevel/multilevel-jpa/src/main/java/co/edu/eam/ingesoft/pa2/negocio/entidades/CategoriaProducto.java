package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA_PRODUCTOS")
public class CategoriaProducto implements Serializable{

	@Id
	@Column(name="CATEGORIA_ID", length=7, nullable=false)
	private int id;
	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION", length=255, nullable=false)
	private String descripcion;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public CategoriaProducto(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public CategoriaProducto() {
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

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
