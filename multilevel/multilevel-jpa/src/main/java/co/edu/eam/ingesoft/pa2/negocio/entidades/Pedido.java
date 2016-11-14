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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.MetodoPagoENUM;

@Entity
@Table(name="PEDIDOS")
@NamedQueries({@NamedQuery(name=Pedido.LISTAR_PEDIDOS,
query="SELECT p FROM Pedido p"),
	@NamedQuery(name=Pedido.LISTAR_PEDIDOS_PENDIENTES,
	query="SELECT p FROM Pedido p WHERE p.estado = ?1 ")})
public class Pedido implements Serializable{

	public static final String LISTAR_PEDIDOS = "Pedidos.listarPedidos";
	public static final String LISTAR_PEDIDOS_PENDIENTES = "Pedidos.listarPedidosPendientes";
	
	@Id
	@Column(name="PEDIDO_ID", length=12, nullable=false)
	private int id;
	
	/**
	 * EL Estado sera 
	 * 'A' Aprobado 
	 * 'N' Negado
	 * 'P' Pendiente
	 */
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
	 * @return the estado
	 */
	public char getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(char estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaPedido
	 */
	public Date getFechaPedido() {
		return fechaPedido;
	}

	/**
	 * @param fechaPedido the fechaPedido to set
	 */
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estado;
		result = prime * result + ((fechaEntrega == null) ? 0 : fechaEntrega.hashCode());
		result = prime * result + ((fechaPedido == null) ? 0 : fechaPedido.hashCode());
		result = prime * result + id;
		result = prime * result + ((metodoPago == null) ? 0 : metodoPago.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + puntos;
		result = prime * result + ((representante == null) ? 0 : representante.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (estado != other.estado)
			return false;
		if (fechaEntrega == null) {
			if (other.fechaEntrega != null)
				return false;
		} else if (!fechaEntrega.equals(other.fechaEntrega))
			return false;
		if (fechaPedido == null) {
			if (other.fechaPedido != null)
				return false;
		} else if (!fechaPedido.equals(other.fechaPedido))
			return false;
		if (id != other.id)
			return false;
		if (metodoPago != other.metodoPago)
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (puntos != other.puntos)
			return false;
		if (representante == null) {
			if (other.representante != null)
				return false;
		} else if (!representante.equals(other.representante))
			return false;
		return true;
	}

	
	
	
}
