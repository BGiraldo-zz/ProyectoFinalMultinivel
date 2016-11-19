package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DESCRIPCION_PREMIOS")
public class DescripcionPremio implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="PREMIO_ID", nullable=false)
	private Premio premio;
	
	@Column(name="DESCRIPCION", length=255, nullable=false)
	private String descripcion;

	/**
	 * @param premio
	 * @param descripcion
	 */
	public DescripcionPremio(Premio premio, String descripcion) {
		this.premio = premio;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public DescripcionPremio() {
	}

	/**
	 * @return the premio
	 */
	public Premio getPremio() {
		return premio;
	}

	/**
	 * @param premio the premio to set
	 */
	public void setPremio(Premio premio) {
		this.premio = premio;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
