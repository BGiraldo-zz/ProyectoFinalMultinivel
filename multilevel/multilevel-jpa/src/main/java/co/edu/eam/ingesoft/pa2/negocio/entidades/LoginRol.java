package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN_ROLES")
@IdClass(LoginRolPK.class)
@NamedQueries({@NamedQuery(name=LoginRol.BUSCAR_LOGIN_ROLES,
query="SELECT lr.rol FROM LoginRol lr WHERE lr.login.id = ?1")})
public class LoginRol implements Serializable{

	public static final String BUSCAR_LOGIN_ROLES = "LoginRoles.buscarLoginRoles";
	
	/*
	 * Atributos
	 */
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ROL_ID", nullable = false)
	private Rol rol;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "LOGIN_ID", nullable = false)
	private Login login;

	/**
	 * @param rol
	 * @param login
	 */
	public LoginRol(Rol rol, Login login) {
		this.rol = rol;
		this.login = login;
	}

	/**
	 * 
	 */
	public LoginRol() {
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
