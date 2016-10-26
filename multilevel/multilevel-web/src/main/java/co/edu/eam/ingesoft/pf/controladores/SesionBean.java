package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Login;

@Named("SesionBean")
@SessionScoped
//@ExceptionLogger
public class SesionBean implements Serializable{

	private Login login;
	
	/**
	 * Metodo para renderizar el menú, según 
	 * el usuario conectado
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public boolean renderizarMenu(int subMenu){
		
		return true;
		
	}
	
	/**
	 * Metodo que Cierra las sesiones activas
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public String logout() {
	//	Faces.getSession().
		return "/paginas/login.jsf?faces-redirect=true";
	}
	

	/**
	 * 
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void login(){
		
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
