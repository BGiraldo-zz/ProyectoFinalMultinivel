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
	@JoinColumn(name="LOGIN_ID", nullable=true)
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
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ""+nombre+" "+apellido;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + genero;
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (genero != other.genero)
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipoDocumento != other.tipoDocumento)
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
	}

	
	
	
	
}
