package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.bos.BOMetaEJB;
import co.edu.eam.ingesoft.pa2.bos.BOPremioEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Meta;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Premio;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoMetaEnum;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("ControladorManejoMeta")
@ViewScoped
@ExceptionLogger
public class ControladorManejoMeta implements Serializable{

	private Meta meta;
	
	@EJB
	private BOMetaEJB metaEJB;
	
	private List<Premio> premios;
	
	private List<TipoMetaEnum> tipoMetas;
	
	@EJB
	private BOPremioEJB premioEJB;
	
	@PostConstruct
	public void inicializar(){
		meta = new Meta();
		premios = premioEJB.listarPremios();
		cargarTipoMetas();
	}

	/**
	 * Carga los tipo metas en una lista para el combo
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void cargarTipoMetas(){
		tipoMetas = new ArrayList<>();
		TipoMetaEnum[] tipos = TipoMetaEnum.values();
		for (int i = 0; i < tipos.length; i++) {
			tipoMetas.add(tipos[i]);
		}
	}
	
	/**
	 * Registra una meta
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void registrar(){
		
		metaEJB.crear(meta);
		Messages.addGlobalInfo("Registrado Correctamente");
		inicializar();
		
	}
	
	/**
	 * Busca una meta
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void buscar(){
		Meta m = metaEJB.buscar(meta.getId());
		meta.setCantidad(m.getCantidad());
		meta.setNombre(m.getNombre());
		meta.setPremio(m.getPremio());
		meta.setTipo(m.getTipo());	
	}
	
	/**
	 * Edita una Meta
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void editar(){
		
		Meta m = metaEJB.buscar(meta.getId());
		m.setCantidad(meta.getCantidad());
		m.setNombre(meta.getNombre());
		m.setPremio(meta.getPremio());
		m.setTipo(meta.getTipo());
		metaEJB.editar(m);
		Messages.addGlobalInfo("Editado Correctamente");
		
	}
	
	/**
	 * Metodo para eliminar una meta
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void eliminar(){
		
		Meta m = metaEJB.buscar(meta.getId());
		metaEJB.eliminar(m);
		Messages.addGlobalInfo("Eliminado Correctamente");
		inicializar();
	}

	/**
	 * @return the tipoMetas
	 */
	public List<TipoMetaEnum> getTipoMetas() {
		return tipoMetas;
	}




	/**
	 * @param tipoMetas the tipoMetas to set
	 */
	public void setTipoMetas(List<TipoMetaEnum> tipoMetas) {
		this.tipoMetas = tipoMetas;
	}




	/**
	 * @return the premios
	 */
	public List<Premio> getPremios() {
		return premios;
	}



	/**
	 * @param premios the premios to set
	 */
	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}



	/**
	 * @return the meta
	 */
	public Meta getMeta() {
		return meta;
	}


	/**
	 * @param meta the meta to set
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
	}


	/**
	 * @return the metaEJB
	 */
	public BOMetaEJB getMetaEJB() {
		return metaEJB;
	}


	/**
	 * @param metaEJB the metaEJB to set
	 */
	public void setMetaEJB(BOMetaEJB metaEJB) {
		this.metaEJB = metaEJB;
	}

	/**
	 * @return the premioEJB
	 */
	public BOPremioEJB getPremioEJB() {
		return premioEJB;
	}

	/**
	 * @param premioEJB the premioEJB to set
	 */
	public void setPremioEJB(BOPremioEJB premioEJB) {
		this.premioEJB = premioEJB;
	}
	
	
	
	
}
