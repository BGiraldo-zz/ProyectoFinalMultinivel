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
@NamedQueries({@NamedQuery(name=Inventario.BUSCAR_INVENTARIO,
query="SELECT i.producto.id,i.producto.nombre,i.cantidad,i.precioBase FROM Inventario i WHERE i.representante.id = ?1")})
public class Inventario implements Serializable{

	public static final String BUSCAR_INVENTARIO = "Inventario.buscarInventario";
	
	@Id
	@Column(name="INVENTARIO_ID", nullable=false, length=12)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;

	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID", nullable=false)
	private Producto producto;
	
	@Column(name="CANTIDAD", length=12, nullable=false)
	private double cantidad;
	
	
	/**
	 * @param id
	 * @param representante
	 * @param producto
	 * @param cantidad
	 * @param precioBase
	 */
	public Inventario(int id, Representante representante, Producto producto, double cantidad, double precioBase) {
		super();
		this.id = id;
		this.representante = representante;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioBase = precioBase;
	}

	@Column(name="PRECIO_BASE",nullable=false, length=10)
	private double precioBase;
	
	

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
	
	
	
	
}
