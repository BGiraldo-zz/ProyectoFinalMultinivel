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
	
	@ManyToOne
    @JoinColumn(name = "INVENTARIO_ID", nullable=false)
	private Inventario inventario;

	@Column(name="CANTIDAD", length=5, nullable=false)
	private int cantidad;
	
	@Column(name="PRECIO_COMPRA", length=7, nullable=false)
	private double precioCompra;

	/**
	 * @param venta
	 * @param inventarioRepresentante
	 * @param cantidad
	 * @param precioCompra
	 */
	public DetalleVenta(Venta venta, Inventario inventario, int cantidad, double precioCompra) {
		this.venta = venta;
		this.inventario = inventario;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
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
	 * @return the inventarioRepresentante
	 */
	public Inventario getInventario() {
		return inventario;
	}

	/**
	 * @param inventarioRepresentante the inventarioRepresentante to set
	 */
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
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
	public double getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * @param precioCompra the precioCompra to set
	 */
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	
	
}
