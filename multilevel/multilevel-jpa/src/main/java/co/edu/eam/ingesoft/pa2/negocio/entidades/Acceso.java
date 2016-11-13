package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ACCESOS")
@NamedQueries({@NamedQuery(name=Acceso.BUSCAR_ACCESOS_ROL,
query="SELECT ar.acceso FROM RolAcceso ar WHERE ar.rol.id = ?1")})
public class Acceso implements Serializable{

	/*
	 * Atributos
	 */
	
	public static final String BUSCAR_ACCESOS_ROL = "Accesos.buscarAccesosRol";
	
	@Id
	@Column(name="ACCESO_ID", length=12, nullable=false)
	private int id;
	
	@Column(name="URL", length=200, nullable=false)
    private String url;
    
	@Column(name="NOMBRE", length=60, nullable=false)
    private String nombre;
	
	/*
	 * Constructor 
	 */
	

	public Acceso(int id, String url, String nombre) {
		super();
		this.id = id;
		this.url = url;
		this.nombre = nombre;
	}

	public Acceso() {
	
	}
	
	/*
	 * Getters and setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
	
}
