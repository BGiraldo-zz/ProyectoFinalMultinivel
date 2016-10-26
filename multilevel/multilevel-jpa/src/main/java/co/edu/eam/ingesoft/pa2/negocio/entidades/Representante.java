package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.EstadoRepresentanteENUM;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoDocumentoENUM;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPersonaENUM;

@Entity
@Table(name="REPRESENTANTES")
public class Representante extends Persona implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="CATEGORIA_REPRESENTANTE_ID", nullable=false)
	private CategoriaRepresentante categoria;
	
	@Column(name="SUELDO_ACTUAL", length=12, nullable=false)
	private double sueldoActual;
	
	
	@Column(name="ACOMULADO_TOTAL", length=15, nullable=false)
	private int acomuladoTotal;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="ESTADO", length=12, nullable=false)
	private EstadoRepresentanteENUM estado;

	/**
	 * @param id
	 * @param email
	 * @param login
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param genero
	 * @param telefono
	 * @param tipoUsuario
	 * @param tipoDocumento
	 * @param categoria
	 * @param sueldoActual
	 * @param acomuladoTotal
	 * @param estado
	 */
	public Representante(int id, String email, Login login, String nombre, String apellido, Date fechaNacimiento,
			char genero, String telefono, TipoPersonaENUM tipoUsuario, TipoDocumentoENUM tipoDocumento,
			CategoriaRepresentante categoria, double sueldoActual, int acomuladoTotal, EstadoRepresentanteENUM estado) {
		super(id, email, login, nombre, apellido, fechaNacimiento, genero, telefono, tipoUsuario, tipoDocumento);
		this.categoria = categoria;
		this.sueldoActual = sueldoActual;
		this.acomuladoTotal = acomuladoTotal;
		this.estado = estado;
	}

	/**
	 * @param id
	 * @param email
	 * @param login
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param genero
	 * @param telefono
	 * @param tipoUsuario
	 * @param tipoDocumento
	 */
	public Representante(int id, String email, Login login, String nombre, String apellido, Date fechaNacimiento,
			char genero, String telefono, TipoPersonaENUM tipoUsuario, TipoDocumentoENUM tipoDocumento) {
		super(id, email, login, nombre, apellido, fechaNacimiento, genero, telefono, tipoUsuario, tipoDocumento);
	}
	
	public Representante(){
		
	}

	/**
	 * @return the categoria
	 */
	public CategoriaRepresentante getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaRepresentante categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the sueldoActual
	 */
	public double getSueldoActual() {
		return sueldoActual;
	}

	/**
	 * @param sueldoActual the sueldoActual to set
	 */
	public void setSueldoActual(double sueldoActual) {
		this.sueldoActual = sueldoActual;
	}

	/**
	 * @return the acomuladoTotal
	 */
	public int getAcomuladoTotal() {
		return acomuladoTotal;
	}

	/**
	 * @param acomuladoTotal the acomuladoTotal to set
	 */
	public void setAcomuladoTotal(int acomuladoTotal) {
		this.acomuladoTotal = acomuladoTotal;
	}

	/**
	 * @return the estado
	 */
	public EstadoRepresentanteENUM getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoRepresentanteENUM estado) {
		this.estado = estado;
	}

	
    
	
}
