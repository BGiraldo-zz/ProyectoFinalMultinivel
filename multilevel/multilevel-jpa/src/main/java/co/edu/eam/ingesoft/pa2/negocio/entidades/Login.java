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
query="SELECT i FROM Representante i where i.login.id = (select u.id from Login u WHERE u.nickname = ?1 and u.pass = ?2)"),
	@NamedQuery(name=Login.BUSCAR_POR_USUARIO_PASS, 
	query="SELECT u FROM Login u WHERE u.nickname = ?1 and u.pass = ?2")})
public class Login implements Serializable{
	
	public static final String BUSCAR_POR_USER_PASS = "Login.buscarUserPass";
	public static final String BUSCAR_POR_USUARIO_PASS = "Login.buscarUsuarioPass";
	
	@Id
	@Column(name="LOGIN_ID", nullable=false, length=12)
	private int id;
	
	//@Size(min = 3, max = 45, message = "La longitud del nickname es incorrecta")
	@Column(name = "NICKNAME", length = 45, nullable = false)
	private String nickname;

	//@Size(min = 3, max = 45, message = "La longitud del password es incorrecta")
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		Login other = (Login) obj;
		if (id != other.id)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	
	
	
	
	
}
