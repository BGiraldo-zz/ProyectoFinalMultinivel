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
@Table(name="PROMOCIONES")
public class Promocion implements Serializable {

	@Id
	@Column(name="PROMOCION_ID", length=12, nullable=false)
	private int id;
	
	@Column(name="DESCUENTO", length=3, nullable=false)
	private int descuento;
	
	@Column(name="FECHA_INICIAL", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaInicial;
	
	@Column(name="FECHA_FINAL", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaFinal;

	/**
	 * @param id
	 * @param descuento
	 * @param fechaInicial
	 * @param fechaFinal
	 */
	public Promocion(int id, int descuento, Date fechaInicial, Date fechaFinal) {
		this.id = id;
		this.descuento = descuento;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	/**
	 * 
	 */
	public Promocion() {
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
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	
	
}
