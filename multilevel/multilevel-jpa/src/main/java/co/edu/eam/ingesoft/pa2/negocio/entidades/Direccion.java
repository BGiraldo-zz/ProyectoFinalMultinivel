package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DIRECCIONES")
@NamedQueries({@NamedQuery(name=Direccion.CANTIDAD_DIRECCIONES,
query = "SELECT count(d.id) FROM Direccion d")})
public class Direccion implements Serializable{

	public static final String CANTIDAD_DIRECCIONES = "Direccion.cantidadDirecciones";
	
	@Id
	@Column(name="DIRECCION_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CIUDAD_ID", nullable=false)
	private Ciudad ciudad;
	
	@Column(name="DESCRIPCION", length=255, nullable=false)
	private String descripcion;

	/**
	 * @param id
	 * @param ciudad
	 * @param descripcion
	 */
	public Direccion(int id, Ciudad ciudad, String descripcion) {
		this.id = id;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public Direccion() {
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
	 * @return the ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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
