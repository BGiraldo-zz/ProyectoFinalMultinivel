package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.bos.BOPromocionEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("ControladorManejoPromocion")
@ViewScoped
@ExceptionLogger
public class ControladorManejoPromocion implements Serializable{

	private Promocion promocion;
	
	@EJB
	private BOPromocionEJB promocionEJB;

	@PostConstruct
	public void inicializar(){
		promocion = new Promocion();
	}
	
	/**
	 * Metodo para registrar Promocion
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void registrar(){
		promocionEJB.crear(promocion);
		Messages.addGlobalInfo("Promoción Registrada Correctamente");
		inicializar();
		
	}
	
	/**
	 * Metodo para buscar Promocion
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void buscar(){
		Promocion promo = promocionEJB.buscar(promocion.getId());
			promocion.setDescuento(promo.getDescuento());
			promocion.setFechaInicial(promo.getFechaInicial());
			promocion.setFechaFinal(promo.getFechaFinal());
		
	}
	
	/**
	 * Metodo para editar Promocion
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void editar(){
		
		Promocion promo = promocionEJB.buscar(promocion.getId());
		
		promo.setDescuento(promocion.getDescuento());
		promo.setFechaInicial(promocion.getFechaInicial());
		promo.setFechaFinal(promocion.getFechaFinal());
		promocionEJB.editar(promo);
		Messages.addGlobalInfo("Promoción Editada Correctamente");

		
	}
	
	/**
	 * Metodo para eliminar Promocion
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void eliminar(){
		
		Promocion promo = promocionEJB.buscar(promocion.getId());
		
		promocionEJB.eliminar(promo);
		Messages.addGlobalInfo("Promoción Eliminada Correctamente");
		inicializar();
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
	 * @return the promocionEJB
	 */
	public BOPromocionEJB getPromocionEJB() {
		return promocionEJB;
	}



	/**
	 * @param promocionEJB the promocionEJB to set
	 */
	public void setPromocionEJB(BOPromocionEJB promocionEJB) {
		this.promocionEJB = promocionEJB;
	}
	
	
	
	
}
