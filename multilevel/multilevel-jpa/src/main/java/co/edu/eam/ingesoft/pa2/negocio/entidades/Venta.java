package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.MetodoPagoENUM;

@Entity
@Table(name = "VENTAS")
public class Venta implements Serializable {

	@Id
	@Column(name = "VENTA_ID", length = 12, nullable = false)
	private int id;

	@OneToOne
	@JoinColumn(name = "CREDITO_ID", nullable = true, unique = true)
	private Credito credito;

	@ManyToOne
	@JoinColumn(name = "REPRESENTANTE_ID", nullable = false)
	private Representante representante;

	@ManyToOne
	@JoinColumn(name="CLIENTE_ID", nullable=false)
	private Persona cliente;

	@Column(name = "FECHAVENTA", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date fechaVenta;

	@Column(name = "TOTALVENTA", length = 12, nullable = true)
	private double totalVenta;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "TIPO_PAGO", nullable = false, length = 45)
	private MetodoPagoENUM tipoPago;
	
	
	/**
	 * @param id
	 * @param representante
	 * @param cliente
	 * @param fechaVenta
	 * @param totalVenta
	 * @param tipoPago
	 */
	public Venta(int id, Representante representante, Persona cliente, Date fechaVenta, double totalVenta,
			MetodoPagoENUM tipoPago) {
		this.id = id;
		this.credito = credito;
		this.representante = representante;
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
		this.totalVenta = totalVenta;
		this.tipoPago = tipoPago;
	}

	/**
	 * 
	 */
	public Venta() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the representante
	 */
	public Representante getRepresentante() {
		return representante;
	}

	/**
	 * @param representante
	 *            the representante to set
	 */
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	/**
	 * @return the cliente
	 */
	public Persona getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the fechaVenta
	 */
	public Date getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * @param fechaVenta
	 *            the fechaVenta to set
	 */
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * @return the totalVenta
	 */
	public double getTotalVenta() {
		return totalVenta;
	}

	/**
	 * @param totalVenta
	 *            the totalVenta to set
	 */
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	/**
	 * @return the tipoPago
	 */
	public MetodoPagoENUM getTipoPago() {
		return tipoPago;
	}

	/**
	 * @param tipoPago
	 *            the tipoPago to set
	 */
	public void setTipoPago(MetodoPagoENUM tipoPago) {
		this.tipoPago = tipoPago;
	}

	/**
	 * @return the credito
	 */
	public Credito getCredito() {
		return credito;
	}

	/**
	 * @param credito the credito to set
	 */
	public void setCredito(Credito credito) {
		this.credito = credito;
	}


	
}
