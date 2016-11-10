package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DETALLE_PEDIDOS")
@IdClass(DetallePedidoPK.class)
public class DetallePedido implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="PEDIDO_ID", nullable=false)
	private Pedido pedido;
	
	@Id
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
	public DetallePedido(Pedido pedido, Producto producto, int cantidad, int puntos,
			double precioProducto) {
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.puntos = puntos;
		this.precioProducto = precioProducto;
	}

	/**
	 * 
	 */
	public DetallePedido() {
	}

	/**
	 * @return the entrega
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
