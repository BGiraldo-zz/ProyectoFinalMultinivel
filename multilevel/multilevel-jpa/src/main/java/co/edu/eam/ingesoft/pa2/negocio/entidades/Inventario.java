package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="INVENTARIOS")
@IdClass(InventarioPK.class)
@NamedQueries({@NamedQuery(name=Inventario.BUSCAR_INVENTARIO,
query="SELECT i.producto.id,i.producto.nombre,i.cantidad,i.precioBase FROM Inventario i WHERE i.representante.id = ?1")})
public class Inventario implements Serializable{

	public static final String BUSCAR_INVENTARIO = "Inventario.buscarInventario";
	
	@Id
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;

	@Id
	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID", nullable=false)
	private Producto producto;
	
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
		this.producto = producto;
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
