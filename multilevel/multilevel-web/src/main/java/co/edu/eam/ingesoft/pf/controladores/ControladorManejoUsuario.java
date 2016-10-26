package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaRepresentante;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Ciudad;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Login;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;

@Named("ControladorManejoUsuario")
@ViewScoped
// @ExceptionLogger
public class ControladorManejoUsuario implements Serializable {

	private Login login;

	private char tipeUser;

	private Representante representante;

	private List<Ciudad> ciudades;

	private List<CategoriaRepresentante> categorias;

	/**
	 * Carga los campos dependiendo del usuario a registrar
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public boolean cargarCampos() {
		if (tipeUser == 'A' || tipeUser == 'V') {
			return false;
		} else if (tipeUser == 'R') {
			return true;
		}
		return false;

	}

	public void registrarUsuario() {

	}

	public void buscarUsuario() {

	}

	public void editarUsuario() {

	}

	public void removerUsuario() {

	}

	/**
	 * @return the ciudades
	 */
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	/**
	 * @param ciudades
	 *            the ciudades to set
	 */
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @return the representante
	 */
	public Representante getRepresentante() {
		return representante;
	}

	/**
	 * @param representante
	 *            the representante to set
	 */
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	/**
	 * @return the categorias
	 */
	public List<CategoriaRepresentante> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias
	 *            the categorias to set
	 */
	public void setCategorias(List<CategoriaRepresentante> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the tipeUser
	 */
	public char getTipeUser() {
		return tipeUser;
	}

	/**
	 * @param tipeUser
	 *            the tipeUser to set
	 */
	public void setTipeUser(char tipeUser) {
		this.tipeUser = tipeUser;
	}

}
