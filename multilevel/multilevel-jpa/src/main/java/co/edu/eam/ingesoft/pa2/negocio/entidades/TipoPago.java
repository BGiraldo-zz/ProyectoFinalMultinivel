package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_PAGOS")
public class TipoPago implements Serializable{

	@Id
	@Column(name="TIPO_PAGO_ID", length=12, nullable=false)
	private int id;
	
	@Column(name="NOMBRE", length=25, nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION", length=255, nullable=false)
	private String descripcion;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public TipoPago(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public TipoPago() {
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
