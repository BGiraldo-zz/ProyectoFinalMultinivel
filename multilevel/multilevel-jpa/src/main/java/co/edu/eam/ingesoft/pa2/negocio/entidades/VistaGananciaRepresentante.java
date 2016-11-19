package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="VISTA_GANANCIA_REPRESENTANTE")
public class VistaGananciaRepresentante implements Serializable{

	@Id
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FECHA", nullable=false)
	private Date fecha;
	
	@Column(name="SUELDO_MENSUAL", length=12, nullable=false)
	private double sueldoMensual;

	/**
	 * @param representante
	 * @param fecha
	 * @param sueldoMensual
	 */
	public VistaGananciaRepresentante(Representante representante, Date fecha, double sueldoMensual) {
		this.representante = representante;
		this.fecha = fecha;
		this.sueldoMensual = sueldoMensual;
	}

	/**
	 * 
	 */
	public VistaGananciaRepresentante() {
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

	/**
	 * @return the sueldoMensual
	 */
	public double getSueldoMensual() {
		return sueldoMensual;
	}

	/**
	 * @param sueldoMensual the sueldoMensual to set
	 */
	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	
	
	
}
