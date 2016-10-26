package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;

@Named("ControladorManejoPromocion")
@ViewScoped
// @ExceptionLogger
public class ControladorManejoPromocion implements Serializable{

	private Promocion promocion;

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
	
	
	
}
