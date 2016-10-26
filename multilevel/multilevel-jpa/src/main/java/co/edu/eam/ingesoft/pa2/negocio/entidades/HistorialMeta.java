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
@Table(name="HISTORIAL_METAS")
public class HistorialMeta implements Serializable{

	@Id
	@Column(name="HISTORIAL_META_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="METAS_ID", nullable=false)
	private Meta meta;
	
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FECHA", nullable=false)
	private Date fecha;
	
	// es el resultado del representante en su meta 
	@Column(name="RESULTADO",length=255,nullable=false)
	private String resultado;

	/**
	 * @param id
	 * @param meta
	 * @param representante
	 * @param fecha
	 * @param resultado
	 */
	public HistorialMeta(int id, Meta meta, Representante representante, Date fecha, String resultado) {
		this.id = id;
		this.meta = meta;
		this.representante = representante;
		this.fecha = fecha;
		this.resultado = resultado;
	}

	/**
	 * 
	 */
	public HistorialMeta() {
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
	 * @return the meta
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * @param meta the meta to set
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
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
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
}
