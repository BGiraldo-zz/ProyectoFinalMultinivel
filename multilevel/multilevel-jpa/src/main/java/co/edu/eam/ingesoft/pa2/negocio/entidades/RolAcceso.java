package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ROL_ACCESOS")
@IdClass(RolAccesoPK.class)
public class RolAcceso implements Serializable{

	/*
	 * Atributos
	 */

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_ROL", nullable = false, updatable = false, insertable = false)
	private Rol rol;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_ACCESO", nullable = false, updatable = false, insertable = false)
	private Acceso acceso;
	
	@Column(name="DESCRIPCION" , length = 255 , nullable=true)
	private String descripcion;

	/**
	 * @param rol
	 * @param acceso
	 * @param descripcion
	 */
	public RolAcceso(Rol rol, Acceso acceso, String descripcion) {
		this.rol = rol;
		this.acceso = acceso;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public RolAcceso() {
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * @return the acceso
	 */
	public Acceso getAcceso() {
		return acceso;
	}

	/**
	 * @param acceso the acceso to set
	 */
	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
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
