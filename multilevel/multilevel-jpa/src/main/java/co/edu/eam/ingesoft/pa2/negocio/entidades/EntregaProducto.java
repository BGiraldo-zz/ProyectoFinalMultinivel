package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ENTREGA_PRODUCTOS")
public class EntregaProducto implements Serializable{

	@Id
	@Column(name="ENTREGA_PRODUCTO_ID", length=12,nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ENTREGA_ID", nullable=false)
	private Entrega entrega;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID", nullable=false )
	private Producto producto;
	
	@Column(name="CANTIDAD", length=12, nullable=false)
	private int cantidad;
	
	@Column(name="PUNTOS", length=12, nullable=false)
	private int puntos;
	
	@Column(name="PRECIO_PRODUCTO", length=6, nullable=false)
	private double precioProducto;

	/**
	 * @param id
	 * @param entrega
	 * @param producto
	 * @param cantidad
	 * @param puntos
	 * @param precioProducto
	 */
	public EntregaProducto(int id, Entrega entrega, Producto producto, int cantidad, int puntos,
			double precioProducto) {
		this.id = id;
		this.entrega = entrega;
		this.producto = producto;
		this.cantidad = cantidad;
		this.puntos = puntos;
		this.precioProducto = precioProducto;
	}

	/**
	 * 
	 */
	public EntregaProducto() {
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
	 * @return the entrega
	 */
	public Entrega getEntrega() {
		return entrega;
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * @return the precioProducto
	 */
	public double getPrecioProducto() {
		return precioProducto;
	}

	/**
	 * @param precioProducto the precioProducto to set
	 */
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	
	
	
}
