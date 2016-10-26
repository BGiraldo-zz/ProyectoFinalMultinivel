package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
//@NamedQueries({@NamedQuery(name= Rol.LISTAR_ROLES_USUARIO, 
//query="SELECT ur.rol FROM UsuarioRol ur WHERE ur.usuario.id = ?1")})
public class Rol implements Serializable{

	/** 
	 * Atributos
	 */
	
//	public static final String LISTAR_ROLES_USUARIO = "Rol.listarRolesUsuario";
	
	@Id
	@Column(name="ID_ROL", length=12, nullable=false)
	private int id;
	
	@Column(name="NOMBRE", length=45, nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION" , length = 255 , nullable=true)
	private String descripcion;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public Rol(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public Rol() {
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
