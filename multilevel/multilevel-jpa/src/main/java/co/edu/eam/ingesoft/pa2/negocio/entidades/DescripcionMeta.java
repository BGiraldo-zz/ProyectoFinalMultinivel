package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DESCRIPCION_METAS")
public class DescripcionMeta implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="META_ID", nullable=false)
	private Meta meta;
	
	@Column(name="DESCRIPCION", length=255, nullable=false)
	private String descripcion;

	/**
	 * @param meta
	 * @param descripcion
	 */
	public DescripcionMeta(Meta meta, String descripcion) {
		this.meta = meta;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public DescripcionMeta() {
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
