package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoDocumentoENUM;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPersonaENUM;

@Entity
@Table(name="PERSONAS")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({@NamedQuery(name=Persona.BUSCAR_PERSONA_LOGIN,
query="SELECT pers FROM Persona pers WHERE pers.login.id = ?1")})
public class Persona implements Serializable {
	
	public static final String BUSCAR_PERSONA_LOGIN = "Persona.buscarPersonaLogin";
	
	@Id
	@Column(name="PERSONA_ID", length=12, nullable=false)
	protected int id;
	
	@Column(name="EMAIL", length=60, nullable=false)
	protected  String email;
	
	@OneToOne
	@JoinColumn(name="LOGIN_ID", nullable=false)
	protected  Login login;

	@Column(name="NOMBRES", length=60, nullable=false)
	protected  String nombre;
	
	@Column(name="APELLIDOS", length=60, nullable=false)
	protected  String apellido;
	
	@Column(name="FECHA_NACIMIENTO", nullable=false)
	@Temporal(value=TemporalType.DATE)
	protected  Date fechaNacimiento;
	
	@Column(name="GENERO", length = 9, nullable=false)
	protected  char genero;
	
	@Column(name="TELEFONO", length=12, nullable=false)
	protected  String telefono;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="TIPO_PERSONA", nullable=false, length=25)
	protected  TipoPersonaENUM tipoUsuario;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="TIPO_DOCUMENTO", length=45, nullable=false)
	protected  TipoDocumentoENUM tipoDocumento;

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
	public Persona(int id, String email, Login login, String nombre, String apellido, Date fechaNacimiento, char genero,
			String telefono, TipoPersonaENUM tipoUsuario, TipoDocumentoENUM tipoDocumento) {
		this.id = id;
		this.email = email;
		this.login = login;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * 
	 */
	public Persona() {
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
	 * @return the tipoUsuario
	 */
	public TipoPersonaENUM getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoPersonaENUM tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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

	
	
}
