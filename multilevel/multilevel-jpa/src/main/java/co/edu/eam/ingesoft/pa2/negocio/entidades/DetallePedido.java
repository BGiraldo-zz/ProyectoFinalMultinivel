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
public class DetallePedido implements Serializable{

	@Id
	@Column(name="DETALLE_PEDIDO_ID",nullable=false, length = 12)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="PEDIDO_ID", nullable=false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID", nullable=false )
	private Producto producto;
	
	@Column(name="CANTIDAD", length=12, nullable=false)
	private int cantidad;
	
	
	
	@Column(name="PRECIO_PRODUCTO", length=12, nullable=false)
	private double precioProducto;



	public DetallePedido(int id, Pedido pedido, Producto producto, int cantidad, double precioProducto) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioProducto = precioProducto;
	}

	public DetallePedido() {
	
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public double getPrecioProducto() {
		return precioProducto;
	}



	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	
	
	
}
