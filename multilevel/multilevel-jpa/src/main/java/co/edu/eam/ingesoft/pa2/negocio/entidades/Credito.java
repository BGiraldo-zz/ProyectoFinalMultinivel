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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.EstadoCreditoENUM;

@Entity
@Table(name="CREDITOS")
public class Credito implements Serializable{

	@Id
	@Column(name="CREDITO_ID", length =12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ENTREGA_ID", nullable=false)
	private Entrega entrega;
	
	@ManyToOne
	@JoinColumn(name="TIPO_PAGO_ID", nullable=false)
	private TipoPago tipoPago;
	
	@Column(name="INTERES", nullable=false, length=3)
	private int interes;
	
	@Column(name="COSTO_TOTAL", nullable=false, length=5)
	private double costoTotal;
	
	@Column(name="MESES", length=3, nullable=false)
	private int meses;
	
	@Column(name="IVA", length=5 ,nullable=false)
	private float iva;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FECHA_INICIAL", nullable=false)
	private Date fechaInicial;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FECHA_FINAL", nullable=false)
	private Date fechaFinal;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="ESTADO", nullable=false, length=12)
	private EstadoCreditoENUM estado;

	/**
	 * @param id
	 * @param entrega
	 * @param tipoPago
	 * @param interes
	 * @param costoTotal
	 * @param meses
	 * @param iva
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param estado
	 */
	public Credito(int id, Entrega entrega, TipoPago tipoPago, int interes, double costoTotal, int meses, float iva,
			Date fechaInicial, Date fechaFinal, EstadoCreditoENUM estado) {
		this.id = id;
		this.entrega = entrega;
		this.tipoPago = tipoPago;
		this.interes = interes;
		this.costoTotal = costoTotal;
		this.meses = meses;
		this.iva = iva;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.estado = estado;
	}

	/**
	 * 
	 */
	public Credito() {
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
	 * @return the entrega
	 */
	public Entrega getEntrega() {
		return entrega;
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	/**
	 * @return the tipoPago
	 */
	public TipoPago getTipoPago() {
		return tipoPago;
	}

	/**
	 * @param tipoPago the tipoPago to set
	 */
	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	/**
	 * @return the interes
	 */
	public int getInteres() {
		return interes;
	}

	/**
	 * @param interes the interes to set
	 */
	public void setInteres(int interes) {
		this.interes = interes;
	}

	/**
	 * @return the costoTotal
	 */
	public double getCostoTotal() {
		return costoTotal;
	}

	/**
	 * @param costoTotal the costoTotal to set
	 */
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	/**
	 * @return the meses
	 */
	public int getMeses() {
		return meses;
	}

	/**
	 * @param meses the meses to set
	 */
	public void setMeses(int meses) {
		this.meses = meses;
	}

	/**
	 * @return the iva
	 */
	public float getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(float iva) {
		this.iva = iva;
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

	/**
	 * @return the estado
	 */
	public EstadoCreditoENUM getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoCreditoENUM estado) {
		this.estado = estado;
	}

	
	
	
}
