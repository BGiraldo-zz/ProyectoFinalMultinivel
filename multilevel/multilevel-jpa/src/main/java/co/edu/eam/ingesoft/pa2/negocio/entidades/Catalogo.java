package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOGOS")
public class Catalogo implements Serializable {

	@Id
	@Column(name = "CATALOGO_ID", length = 12, nullable = false)
	private int id;

	@Column(name = "CANTIDAD_PRODUCTOS", length = 12, nullable = false)
	private int cantidadProductos;

	@Column(name = "NOMBRE", nullable = false, length = 60)
	private String nombre;

	/**
	 * @param id
	 * @param cantidadProductos
	 * @param nombre
	 */
	public Catalogo(int id, int cantidadProductos, String nombre) {
		this.id = id;
		this.cantidadProductos = cantidadProductos;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public Catalogo() {
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
	 * @return the cantidadProductos
	 */
	public int getCantidadProductos() {
		return cantidadProductos;
	}

	/**
	 * @param cantidadProductos the cantidadProductos to set
	 */
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
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
