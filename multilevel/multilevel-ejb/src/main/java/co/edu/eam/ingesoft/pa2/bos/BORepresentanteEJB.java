package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Persona;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;

@Stateless
@LocalBean
public class BORepresentanteEJB extends EJBGenerico<Representante> implements InterfaceEJBRemote<Representante> {

	@Override
	public Class getClase() {
		return Representante.class;
	}
	
	@EJB
	private BOPersonaEJB personaEJB;

	@Override
	public void crear(Representante entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una persona con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
		
	}

	@Override
	public Representante buscar(Object pk) {
				Representante r = dao.buscar(pk);
				if(r!=null){
				return r;
			}else{
				throw new ExcepcionFuncional("No existe una persona con este codigo " + pk);
			}
	}

	@Override
	public void editar(Representante entidad) {
			dao.editar(entidad);
	}

	@Override
	public void eliminar(Representante entidad) {
			dao.borrar(entidad);
	}
	
	/**
	 * Lista los representantes disponibles en la BD
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Representante> listarRepresentantes(){
		return dao.ejecutarNamedQuery(Representante.LISTAR_REPRESENTANTES);
	}


}
