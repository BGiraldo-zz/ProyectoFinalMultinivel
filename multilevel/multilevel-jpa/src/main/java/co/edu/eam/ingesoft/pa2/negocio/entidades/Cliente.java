package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable{

	@Id
	@Column(name="CLIENTE_ID", length= 12, nullable=false)
	private int id;
	
	@Column(name="NOMBRES", length=55, nullable=false)
	private String nombre;
	
	@Column(name="APELLIDOS", length=55, nullable=false)
	private String apellido;
	
	@Column(name="DIRECCION", length=60, nullable=false)
	private String direccion;
	
	@Column(name="GENERO", length = 9, nullable=false)
	private char genero;
	
	@Column(name="TELEFONO", length=55, nullable=false)
	private int telefono;
	
	@Column(name="EMAIL", length=60, nullable=false)
	private String email;

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param genero
	 * @param telefono
	 * @param email
	 */
	public Cliente(int id, String nombre, String apellido, String direccion, char genero, int telefono, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.genero = genero;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * 
	 */
	public Cliente() {
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the genero
	 */
	public char getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(char genero) {
		this.genero = genero;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
}
