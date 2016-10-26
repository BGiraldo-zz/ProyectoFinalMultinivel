package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="VENTAS")
public class Venta implements Serializable{

	@Id
	@Column(name="VENTA_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;
	
	@ManyToOne
	@JoinColumn(name="CLIENTE_ID", nullable=false)
	private Cliente cliente;
	
	@Column(name="FECHA_VENTA", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaVenta;
	
	@Column(name="TOTAL_VENTA", length=12, nullable=false)
	private double totalVenta;

	/**
	 * @param id
	 * @param representante
	 * @param cliente
	 * @param fechaVenta
	 * @param totalVenta
	 */
	public Venta(int id, Representante representante, Cliente cliente, Date fechaVenta, double totalVenta) {
		this.id = id;
		this.representante = representante;
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
		this.totalVenta = totalVenta;
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
	 * @param id the id to set
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
	 * @param representante the representante to set
	 */
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the fechaVenta
	 */
	public Date getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * @param fechaVenta the fechaVenta to set
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
	 * @param totalVenta the totalVenta to set
	 */
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	
	
}
