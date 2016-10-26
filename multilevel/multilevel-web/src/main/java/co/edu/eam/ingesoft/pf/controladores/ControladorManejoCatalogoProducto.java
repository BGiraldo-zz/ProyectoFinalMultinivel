package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;

@Named("ControladorManejoCatalogoProducto")
@ViewScoped
// @ExceptionLogger
public class ControladorManejoCatalogoProducto implements Serializable {

	private CatalogoProducto entidad;

	private List<Catalogo> catalogos;

	private List<Producto> productos;

	public void registrarCatalogoProducto() {

	}

	public void buscarCatalogoProducto() {

	}

	public void editarCatalogoProducto() {

	}

	public void removerCatalogoProducto() {

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
