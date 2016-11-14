package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.bos.BOCatalogoEJB;
import co.edu.eam.ingesoft.pa2.bos.BOCatalogoProductoEJB;
import co.edu.eam.ingesoft.pa2.bos.BOProductoEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("ControladorManejoCatalogoProducto")
@ViewScoped
@ExceptionLogger
public class ControladorManejoCatalogoProducto implements Serializable {

	private CatalogoProducto entidad;

	private List<Catalogo> catalogos;

	private List<Producto> productos;
	
	@EJB
	private BOCatalogoProductoEJB catalogoProductoEJB;
	
	@EJB
	private BOCatalogoEJB catalogoEJB;
	
	@EJB
	private BOProductoEJB productoEJB;
	
	@PostConstruct
	public void inicializar(){
		entidad = new CatalogoProducto();
		catalogos = catalogoEJB.listarCatalogos();
		productos = productoEJB.listarProductos();

	}

	/**
	 * Registra un producto en un catalogo
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void registrarCatalogoProducto() {

		catalogoProductoEJB.crear(entidad);
		Messages.addGlobalInfo("Registrado Correctamente");
		inicializar();
		
	}

	/**
	 * Busca un catalogo Producto
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void buscarCatalogoProducto() {

		CatalogoProducto cp = catalogoProductoEJB.buscarCatalogoProducto(entidad.getCatalogo().getId(),
																        entidad.getProducto().getId());
		entidad.setCantidadProducto(cp.getCantidadProducto());
		
	}

	/**
	 * Edita un catalogo producto
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void editarCatalogoProducto() {

		catalogoProductoEJB.editar(entidad);
		Messages.addGlobalInfo("Editado Correctamente");
		
	}

	/**
	 * Elimina un producto de un catalogo (toda la cantidad)
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void removerCatalogoProducto() {

		catalogoProductoEJB.eliminar(entidad);
		Messages.addGlobalInfo("Eliminado Correctamente");
		inicializar();
		
	}

	/**
	 * @return the entidad
	 */
	public CatalogoProducto getEntidad() {
		return entidad;
	}

	/**
	 * @param entidad
	 *            the entidad to set
	 */
	public void setEntidad(CatalogoProducto entidad) {
		this.entidad = entidad;
	}

	/**
	 * @return the catalogos
	 */
	public List<Catalogo> getCatalogos() {
		return catalogos;
	}

	/**
	 * @param catalogos
	 *            the catalogos to set
	 */
	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos
	 *            the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
