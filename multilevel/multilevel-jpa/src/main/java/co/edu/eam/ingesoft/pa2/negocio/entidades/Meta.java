package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoMetaEnum;

@Entity
@Table(name="METAS")
public class Meta implements Serializable{

	@Id
	@Column(name="META_ID", length=7, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="PREMIO_ID", nullable=false)
	private Premio premio;
	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;

	@Column(name="CANTIDAD", length=7, nullable=false)
	private double cantidad;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="TIPO", length=55, nullable=false)
	private TipoMetaEnum tipo;

	/**
	 * @param id
	 * @param premio
	 * @param nombre
	 * @param cantidad
	 * @param tipo
	 */
	public Meta(int id, Premio premio, String nombre, double cantidad, TipoMetaEnum tipo) {
		this.id = id;
		this.premio = premio;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tipo = tipo;
	}

	/**
	 * 
	 */
	public Meta() {
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cantidad
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the tipo
	 */
	public TipoMetaEnum getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoMetaEnum tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
