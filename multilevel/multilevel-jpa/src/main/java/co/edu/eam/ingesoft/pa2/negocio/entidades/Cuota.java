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
@Table(name="CUOTAS")
public class Cuota implements Serializable{

	@Id
	@Column(name="CUOTA_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CREDITO_ID", nullable=false)
	private Credito credito;
	
	@Column(name="MONTO", nullable=false, length=12)
	private double monto;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FECHA", nullable=false)
	private Date fecha;

	/**
	 * @param id
	 * @param credito
	 * @param monto
	 * @param fecha
	 */
	public Cuota(int id, Credito credito, double monto, Date fecha) {
		this.id = id;
		this.credito = credito;
		this.monto = monto;
		this.fecha = fecha;
	}

	/**
	 * 
	 */
	public Cuota() {
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

	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
}
