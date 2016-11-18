package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Persona;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPersonaENUM;
import co.edu.eam.ingesoft.pa2.util.ConstantesNamedQueries;

@Stateless
@LocalBean
public class BOPersonaEJB extends EJBGenerico<Persona> implements InterfaceEJBRemote<Persona>{

	@Override
	public void crear(Persona entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una persona con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Persona buscar(Object pk) {
		Persona p = dao.buscar(pk);
		if(p!=null){
			return p;
		}else{
			throw new ExcepcionFuncional("No existe una persona con esta Identificación " + pk);
		}
	}
	
	@Override
	public void editar(Persona entidad) {
	 dao.editar(entidad);
	}

	@Override
	public void eliminar(Persona entidad) {
		dao.borrar(entidad);
	}

	@Override
	public Class getClase() {
		return Persona.class;
	}

	/**
	 * Busca una persona por login
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public Persona buscarPersonaLogin(int idLogin){
		try{
		Persona p = dao.ejecutarQuery(Persona.BUSCAR_PERSONA_LOGIN, idLogin);
		return p;
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Busca una persona en su propio tipo
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public Persona buscarPersonaTipo(int idPersona, TipoPersonaENUM tipo){
		try{
			Persona p = dao.ejecutarQuery(Persona.BUSCAR_PERSONA_TIPO, idPersona, tipo);
			return p;
			}catch(Exception e){
				return null;
			}
	}
	
	/**
	 * Busca y mira si existe una persona
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public Persona buscarPersonaExist(Object id){
		return dao.buscar(id);
	}
	
}
