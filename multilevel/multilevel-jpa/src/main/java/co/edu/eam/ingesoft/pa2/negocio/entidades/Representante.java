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

@Entity
@Table(name="REPRESENTANTES")
public class Representante implements Serializable {

	@Id
	@Column(name="REPRESENTANTE_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CIUDAD_ID", nullable=false)
	private Ciudad ciudad;
	
	@ManyToOne
	@JoinColumn(name="CATEGORIA_REPRESENTANTE_ID", nullable=false)
	private CategoriaRepresentante categoria;
	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;
	
	@Column(name="APELLIDO", length=60, nullable=false)
	private String apellido;
	
	
	@Column(name="DIRECCION", length=255, nullable=false)
	private String direccion;
	
	@Column(name="FECHA_NACIMIENTO", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name="GENERO", length = 9, nullable=false)
	private char genero;
	
	@Column(name="TELEFONO", length=12, nullable=false)
	private String telefono;
	
	@Column(name="SUELDO_ACTUAL", length=12, nullable=false)
	private double sueldoActual;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="TIPO_DOCUMENTO", length=45, nullable=false)
	private TipoDocumentoENUM tipoDocumento;

	@Column(name="EMAIL", length=60, nullable=false)
	private String email;
	
	@Column(name="ACOMULADO_TOTAL", length=15, nullable=false)
	private int acomuladoTotal;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="ESTADO", length=12, nullable=false)
	private EstadoRepresentanteENUM estado;

	@OneToOne
	@JoinColumn(name="LOGIN_ID", nullable=false)
	private Login login;

	/**
	 * @param id
	 * @param ciudad
	 * @param categoria
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param fechaNacimiento
	 * @param genero
	 * @param telefono
	 * @param sueldoActual
	 * @param tipoDocumento
	 * @param email
	 * @param acomuladoTotal
	 * @param estado
	 * @param login
	 */
	public Representante(int id, Ciudad ciudad, CategoriaRepresentante categoria, String nombre, String apellido,
			String direccion, Date fechaNacimiento, char genero, String telefono, double sueldoActual,
			TipoDocumentoENUM tipoDocumento, String email, int acomuladoTotal, EstadoRepresentanteENUM estado,
			Login login) {
		this.id = id;
		this.ciudad = ciudad;
		this.categoria = categoria;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.telefono = telefono;
		this.sueldoActual = sueldoActual;
		this.tipoDocumento = tipoDocumento;
		this.email = email;
		this.acomuladoTotal = acomuladoTotal;
		this.estado = estado;
		this.login = login;
	}

	/**
	 * 
	 */
	public Representante() {
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
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	 * @return the tipoDocumento
	 */
	public TipoDocumentoENUM getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDocumentoENUM tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
}
