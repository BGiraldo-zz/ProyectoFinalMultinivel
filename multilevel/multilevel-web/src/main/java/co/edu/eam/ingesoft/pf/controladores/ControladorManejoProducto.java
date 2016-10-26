package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaProducto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;

@Named("ControladorManejoProducto")
@ViewScoped
//@ExceptionLogger
public class ControladorManejoProducto implements Serializable {

	private Producto producto;
	
	private List<CategoriaProducto> categorias;
	
	private List<Promocion> promociones;
	
	private CategoriaProducto categoria;
	
	private Promocion promocion;

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the categorias
	 */
	public List<CategoriaProducto> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<CategoriaProducto> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the promociones
	 */
	public List<Promocion> getPromociones() {
		return promociones;
	}

	/**
	 * @param promociones the promociones to set
	 */
	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	/**
	 * @return the promocion
	 */
	public Promocion getPromocion() {
		return promocion;
	}

	/**
	 * @param promocion the promocion to set
	 */
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	/**
	 * @return the categoria
	 */
	public CategoriaProducto getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}
	
	
	
}
