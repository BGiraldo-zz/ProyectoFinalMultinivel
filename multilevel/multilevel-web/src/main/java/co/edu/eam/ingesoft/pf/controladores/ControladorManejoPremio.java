package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.bos.BOPremioEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Premio;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPremioENUM;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("ControladorManejoPremio")
@ViewScoped
@ExceptionLogger
public class ControladorManejoPremio implements Serializable {

	private Premio premio;
	
	private List<TipoPremioENUM> tipoPremios;
	
	@EJB
	private BOPremioEJB premioEJB;

	@PostConstruct
	public void inicializar(){
		
		premio = new Premio();
		cargarTipoPremios();
		
	}
	
	/**
	 * Metodo para registrar premio
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void registrar(){
		premioEJB.crear(premio);
		Messages.addGlobalInfo("Registrado Correctamente");
		inicializar();
	}
	
	/**
	 * Busca un premio
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void buscar(){
		Premio p = premioEJB.buscar(premio.getId());
		premio.setNombre(p.getNombre());
		premio.setTipoPremio(p.getTipoPremio());
		premio.setValor(p.getValor());
	}
	
	public void editar(){
		
		Premio p = premioEJB.buscar(premio.getId());
		p.setNombre(premio.getNombre());
		p.setTipoPremio(premio.getTipoPremio());
		p.setValor(premio.getValor());
		premioEJB.editar(p);
		Messages.addGlobalInfo("Editado Correctamente");
		
	}
	
	public void eliminar(){
		Premio p = premioEJB.buscar(premio.getId());
		premioEJB.eliminar(p);
		Messages.addGlobalInfo("Eliminado Correctamente");
		inicializar();
	}
	
	/**
	 * Carga los tipo premios en una lista
	 * para mostrar en el combo
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void cargarTipoPremios(){
		tipoPremios = new ArrayList<>();
		TipoPremioENUM[] tips = TipoPremioENUM.values();
		
		for (int i = 0; i < tips.length; i++) {
			tipoPremios.add(tips[i]);
		}
	}
	
	
	/**
	 * @return the premio
	 */
	public Premio getPremio() {
		return premio;
	}

	/**
	 * @param premio the premio to set
	 */
	public void setPremio(Premio premio) {
		this.premio = premio;
	}

	/**
	 * @return the tipoPremios
	 */
	public List<TipoPremioENUM> getTipoPremios() {
		return tipoPremios;
	}

	/**
	 * @param tipoPremios the tipoPremios to set
	 */
	public void setTipoPremios(List<TipoPremioENUM> tipoPremios) {
		this.tipoPremios = tipoPremios;
	}
	
	
	
	
}
