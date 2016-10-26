package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class LoginRolPK implements Serializable {

	/*
	 * Atributos
	 */
	
	private int rol;
	
	private int login;

	/**
	 * @param rol
	 * @param login
	 */
	public LoginRolPK(int rol, int login) {
		this.rol = rol;
		this.login = login;
	}

	/**
	 * 
	 */
	public LoginRolPK() {
	}

	/**
	 * @return the rol
	 */
	public int getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(int rol) {
		this.rol = rol;
	}

	/**
	 * @return the login
	 */
	public int getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(int login) {
		this.login = login;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + login;
		result = prime * result + rol;
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
		LoginRolPK other = (LoginRolPK) obj;
		if (login != other.login)
			return false;
		if (rol != other.rol)
			return false;
		return true;
	}

	
	
	
}
