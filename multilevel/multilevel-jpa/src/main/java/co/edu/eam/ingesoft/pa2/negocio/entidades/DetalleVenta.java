package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DETALLE_VENTAS")
public class DetalleVenta implements Serializable {
	
	@Id
	@Column(name="DETALLE_VENTA_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="VENTA_ID", nullable=false)
	private Venta venta;
	
	@ManyToOne
    @JoinColumn(name = "REPRESENTANTE_ID", insertable = false, updatable = false, 
				  referencedColumnName="REPRESENTANTE_ID")
	private Inventario inventarioRepresentante;

	@Column(name="CANTIDAD", length=5, nullable=false)
	private int cantidad;
	
	@Column(name="PRECIO_COMPRA", length=7, nullable=false)
	private double precioCompra;

	/**
	 * @param id
	 * @param venta
	 * @param inventarioRepresentante
	 * @param cantidad
	 * @param precioCompra
	 */
	public DetalleVenta(int id, Venta venta, Inventario inventarioRepresentante, int cantidad, double precioCompra) {
		this.id = id;
		this.venta = venta;
		this.inventarioRepresentante = inventarioRepresentante;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
	}

	/**
	 * 
	 */
	public DetalleVenta() {
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
	public Inventario getInventarioRepresentante() {
		return inventarioRepresentante;
	}

	/**
	 * @param inventarioRepresentante the inventarioRepresentante to set
	 */
	public void setInventarioRepresentante(Inventario inventarioRepresentante) {
		this.inventarioRepresentante = inventarioRepresentante;
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
