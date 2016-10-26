package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CatalogoProducto;

@Named("ControladorManejoCatalogo")
@ViewScoped
//@ExceptionLogger
public class ControladorManejoCatalogo implements Serializable {

	private Catalogo catalogo;
	
	private CatalogoProducto CatalogoProducto;
	
	public void registrarCatalogo(){
		
	}
	
	public void buscarCatalogo(){
		
	}
	
	public void editarCatalogo(){
		
	}
	
	public void removerCatalogo(){
		
	}

	/**
	 * @return the catalogo
	 */
	public Catalogo getCatalogo() {
		return catalogo;
	}

	/**
	 * @param catalogo the catalogo to set
	 */
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	/**
	 * @return the catalogoProducto
	 */
	public CatalogoProducto getCatalogoProducto() {
		return CatalogoProducto;
	}

	/**
	 * @param catalogoProducto the catalogoProducto to set
	 */
	public void setCatalogoProducto(CatalogoProducto catalogoProducto) {
		CatalogoProducto = catalogoProducto;
	}
	
	
	
	
}
