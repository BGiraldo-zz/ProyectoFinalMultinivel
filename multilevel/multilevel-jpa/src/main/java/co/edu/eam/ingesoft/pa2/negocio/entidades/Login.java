package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoUsuarioENUM;

@Entity
@Table(name="LOGINS",uniqueConstraints={
		   @UniqueConstraint(columnNames={"nickname", "pass"})
		})
public class Login implements Serializable{

	@Id
	@Column(name="LOGIN_ID", nullable=false, length=12)
	private int id;
	
	@Size(min = 3, max = 45, message = "La longitud del nickname es incorrecta")
	@Column(name = "NICKNAME", length = 45, nullable = false)
	private String nickname;

	@Size(min = 3, max = 45, message = "La longitud del password es incorrecta")
	@Column(name = "PASS", length = 45, nullable = false)
	private String pass;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="TIPO_USUARIO", nullable=false, length=25)
	private TipoUsuarioENUM tipoUsuario;

	/**
	 * @param id
	 * @param nickname
	 * @param pass
	 * @param tipoUsuario
	 */
	public Login(int id, String nickname, String pass, TipoUsuarioENUM tipoUsuario) {
		this.id = id;
		this.nickname = nickname;
		this.pass = pass;
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * 
	 */
	public Login() {
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
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the tipoUsuario
	 */
	public TipoUsuarioENUM getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuarioENUM tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	
	
}
