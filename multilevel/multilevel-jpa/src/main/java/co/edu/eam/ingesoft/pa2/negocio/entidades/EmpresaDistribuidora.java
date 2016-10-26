package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPRESA_DISTRIBUIDORAS")
public class EmpresaDistribuidora implements Serializable{

	@Id
	@Column(name="EMPRESAD_NIF", length=3, nullable=false)
	private int NIF;
	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;
	
	@Column(name="DIRECCION", length=60, nullable=false)
	private String direccion;
	
	@Column(name="TELEFONO", length=12, nullable=false)
	private String telefono;
	
	@Column(name="EMAIL", length=60, nullable=false)
	private String email;

	/**
	 * @param nIF
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 */
	public EmpresaDistribuidora(int nIF, String nombre, String direccion, String telefono, String email) {
		NIF = nIF;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * 
	 */
	public EmpresaDistribuidora() {
	}

	/**
	 * @return the nIF
	 */
	public int getNIF() {
		return NIF;
	}

	/**
	 * @param nIF the nIF to set
	 */
	public void setNIF(int nIF) {
		NIF = nIF;
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
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
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
