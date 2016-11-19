package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DETALLE_VENTAS")
@IdClass(DetalleVentaPK.class)
public class DetalleVenta implements Serializable {
	

	@Id
	@ManyToOne
	@JoinColumn(name="VENTA_ID", nullable=false)
	private Venta venta;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "PRODUCTO_ID", nullable = false)
	private Producto producto;

	@Column(name="CANTIDAD", length=5, nullable=false)
	private int cantidad;
	
	@Column(name="PRECIO_VENTA", length=7, nullable=false)
	private double precioVenta;

	/**
	 * @param venta
	 * @param inventarioRepresentante
	 * @param cantidad
	 * @param precioCompra
	 */
	public DetalleVenta(Venta venta, Producto producto, int cantidad, double precioVenta) {
		super();
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
	}
	

	/**
	 * 
	 */
	public DetalleVenta() {
	}

	

	/**
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
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
	 * @return the precioCompra
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioCompra the precioCompra to set
	 */
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	
	
}
