package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="INVENTARIOS")
public class Inventario implements Serializable{

	@Id
	@Column(name="INVENTARIO_ID", nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;

	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID", nullable=false)
	private Producto Producto;
	
	@Column(name="CANTIDAD", length=12, nullable=false)
	private double cantidad;
	
	@Column(name="PRECIO_BASE",nullable=false, length=7)
	private double precioBase;

	/**
	 * @param representante
	 * @param producto
	 * @param cantidad
	 * @param precioBase
	 */
	public Inventario(Representante representante, Producto producto,
			double cantidad, double precioBase) {
		this.representante = representante;
		Producto = producto;
		this.cantidad = cantidad;
		this.precioBase = precioBase;
	}

	/**
	 * 
	 */
	public Inventario() {
	}

	/**
	 * @return the representante
	 */
	public Representante getRepresentante() {
		return representante;
	}

	/**
	 * @param representante the representante to set
	 */
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return Producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		Producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precioBase
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * @param precioBase the precioBase to set
	 */
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	
	
}
