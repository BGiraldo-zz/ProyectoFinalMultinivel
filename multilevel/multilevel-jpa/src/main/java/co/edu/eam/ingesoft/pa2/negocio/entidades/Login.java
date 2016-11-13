package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity
@Table(name="LOGINS",uniqueConstraints={
		   @UniqueConstraint(columnNames={"nickname", "pass"})
		})
@NamedQueries({@NamedQuery(name=Login.BUSCAR_POR_USER_PASS,
query="SELECT u FROM Login u WHERE u.nickname = ?1 and u.pass = ?2")})
public class Login implements Serializable{
	
	public static final String BUSCAR_POR_USER_PASS = "Login.buscarUserPass";
	
	@Id
	@Column(name="LOGIN_ID", nullable=false, length=12)
	private int id;
	
	@Size(min = 3, max = 45, message = "La longitud del nickname es incorrecta")
	@Column(name = "NICKNAME", length = 45, nullable = false)
	private String nickname;

	@Size(min = 3, max = 45, message = "La longitud del password es incorrecta")
	@Column(name = "PASS", length = 45, nullable = false)
	private String pass;
	
	

	/**
	 * @param id
	 * @param nickname
	 * @param pass
	 */
	public Login(int id, String nickname, String pass, String tipousuario) {
		this.id = id;
		this.nickname = nickname;
		this.pass = pass;
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
	
	
	
	
}
