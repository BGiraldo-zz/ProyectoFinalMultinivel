package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.bos.BOCatalogoEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("ControladorManejoCatalogo")
@ViewScoped
@ExceptionLogger
public class ControladorManejoCatalogo implements Serializable {

	private Catalogo catalogo;

	@EJB
	private BOCatalogoEJB catalogoEJB;

	@PostConstruct
	public void inicializar() {
		catalogo = new Catalogo();
	}

	/**
	 * Metodo para registrar catalogo
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public void registrarCatalogo() {
		catalogoEJB.crear(catalogo);
		Messages.addGlobalInfo("Registrado Correctamente");
		inicializar();

	}

	/**
	 * metodo para buscar catalogo
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public void buscarCatalogo() {

		Catalogo cat = catalogoEJB.buscar(catalogo.getId());

		catalogo.setNombre(cat.getNombre());
		catalogo.setCantidadProductos(cat.getCantidadProductos());

	}

	/**
	 * metodo para editar catalogo
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public void editarCatalogo() {

		Catalogo cat = catalogoEJB.buscar(catalogo.getId());

		cat.setNombre(catalogo.getNombre());
		cat.setCantidadProductos(catalogo.getCantidadProductos());
		catalogoEJB.editar(cat);
		Messages.addGlobalInfo("Editado Correctamente");

	}

	/**
	 * metodo para eliminar catalogo
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public void removerCatalogo() {

		Catalogo cat = catalogoEJB.buscar(catalogo.getId());

		catalogoEJB.eliminar(cat);
		Messages.addGlobalInfo("Eliminado Correctamente");
		inicializar();

	}

	/**
	 * @return the catalogo
	 */
	public Catalogo getCatalogo() {
		return catalogo;
	}

	/**
	 * @param catalogo
	 *            the catalogo to set
	 */
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}
