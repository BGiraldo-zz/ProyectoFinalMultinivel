package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.MetodoPagoENUM;

@Entity
@Table(name="PEDIDOS")
public class Pedido implements Serializable{

	@Id
	@Column(name="PEDIDO_ID", length=12, nullable=false)
	private int id;
	
	@Column(name="ESTADO", length=2, nullable=false)
	private char estado;
	
	@Column(name="FECHA_PEDIDO",nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaPedido;
	
	@Column(name="FECHA_ENTREGA",nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaEntrega;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="METODO_PAGO", length=60, nullable=false)
	private MetodoPagoENUM metodoPago;
	
	@Column(name="PRECIO", length=12, nullable=false)
	private double precio;
	
	@Column(name="PUNTOS", length=5, nullable=false)
	private int puntos;
	
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;

	/**
	 * @param id
	 * @param empDistribuidora
	 * @param fechaEntrega
	 * @param metodoPago
	 * @param precio
	 * @param puntos
	 */
	public Pedido(int id, char estado, Date fechaPedido, Date fechaEntrega, MetodoPagoENUM metodoPago, double precio,
			int puntos, Representante representante) {
		super();
		this.id = id;
		this.estado = estado;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.metodoPago = metodoPago;
		this.precio = precio;
		this.puntos = puntos;
		this.representante = representante;
	}

	/**
	 * 
	 */
	public Pedido() {
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
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the metodoPago
	 */
	public MetodoPagoENUM getMetodoPago() {
		return metodoPago;
	}

	/**
	 * @param metodoPago the metodoPago to set
	 */
	public void setMetodoPago(MetodoPagoENUM metodoPago) {
		this.metodoPago = metodoPago;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
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

	
	
}
