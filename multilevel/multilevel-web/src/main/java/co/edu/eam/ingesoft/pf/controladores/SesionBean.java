package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import javax.enterprise.context.SessionScoped;

import co.edu.eam.ingesoft.pa2.bos.BOAccesoEJB;
import co.edu.eam.ingesoft.pa2.bos.BOLoginEJB;
import co.edu.eam.ingesoft.pa2.bos.BOPersonaEJB;
import co.edu.eam.ingesoft.pa2.bos.BORolEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Login;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Persona;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Rol;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPersonaENUM;
import co.edu.eam.ingesoft.pa2.util.MD5Util;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("SesionBean")
@SessionScoped
@ExceptionLogger
public class SesionBean implements Serializable {

	private Persona user;
	
	private String nickname;
	
	private String pass;

	private List<Acceso> accesos;

	private List<Rol> roles;

	@EJB
	private BOPersonaEJB personaEJB;

	@EJB
	private BORolEJB rolEJB;

	@EJB
	private BOAccesoEJB accesoEJB;
	
	@EJB
	private BOLoginEJB loginEJB;

	@PostConstruct
	public void inicializar() {

	}

	/**
	 * Metodo para ingresar
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public String login() {

		Login l = loginEJB.buscarLoginUserPass(nickname, pass);
		
		user = personaEJB.buscarPersonaLogin(l.getId());

		if (user != null) {

			TipoPersonaENUM t = user.getTipoUsuario();
			if (t.equals(TipoPersonaENUM.ADMINISTRADOR)) {
				roles = rolEJB.buscarRolesLogin(user.getLogin().getId());
				accesos = accesoEJB.listarAccesosRol(roles);
				Messages.addFlashGlobalInfo("Se ha iniciado sesion correctamente !!!");
				return "/paginas/index.jsf?faces-redirect=true";

			} else {
				return "/login.jsf?faces-redirect=true";
			}

		} else {
			user = null;
			accesos = null;
			roles = null;
		}
		return "/login.jsf?faces-redirect=true";
	}

	/**
	 * Metodo para renderizar el menú, según el usuario conectado
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public boolean renderizarMenu(int subMenu) {
		
		for (Rol r : roles) {
			if (r.getDescripcion().equals("Admin"))
				return true;
		}
		
		switch (subMenu) {
		
            case 1: // Menu Manejo Usuario
           /**	
			for (Rol r : roles) {
				if (r.getDescripcion().equals("Admin") || r.getDescripcion().equals("Vicerrector")) {
					return true;
				}
			}
            **/
			break;
		
		
		}
		return false;
	}

	/**
	 * Metodo que Cierra las sesiones activas
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public String logout() {
		Faces.getSession().invalidate();
		return "/login.jsf?faces-redirect=true";
	}
	
	/**
	 * Metodo que veifica si esta logueado el usuario
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public boolean isloged() {
		return user != null;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return user;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.user = persona;
	}

	/**
	 * @return the accesos
	 */
	public List<Acceso> getAccesos() {
		return accesos;
	}

	/**
	 * @param accesos the accesos to set
	 */
	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	/**
	 * @return the personaEJB
	 */
	public BOPersonaEJB getPersonaEJB() {
		return personaEJB;
	}

	/**
	 * @param personaEJB the personaEJB to set
	 */
	public void setPersonaEJB(BOPersonaEJB personaEJB) {
		this.personaEJB = personaEJB;
	}

	/**
	 * @return the rolEJB
	 */
	public BORolEJB getRolEJB() {
		return rolEJB;
	}

	/**
	 * @param rolEJB the rolEJB to set
	 */
	public void setRolEJB(BORolEJB rolEJB) {
		this.rolEJB = rolEJB;
	}

	/**
	 * @return the accesoEJB
	 */
	public BOAccesoEJB getAccesoEJB() {
		return accesoEJB;
	}

	/**
	 * @param accesoEJB the accesoEJB to set
	 */
	public void setAccesoEJB(BOAccesoEJB accesoEJB) {
		this.accesoEJB = accesoEJB;
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
