package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DESCRIPCION_PRODUCTOS")
public class DescripcionProducto implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID")
	private Producto producto;
	
	@Column(name="DESCRIPCION", length=255, nullable=false)
	private String descripcion;

	/**
	 * @param producto
	 * @param descripcion
	 */
	public DescripcionProducto(Producto producto, String descripcion) {
		this.producto = producto;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public DescripcionProducto() {
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
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
