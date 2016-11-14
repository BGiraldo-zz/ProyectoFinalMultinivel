package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Direccion;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Persona;
import co.edu.eam.ingesoft.pa2.negocio.entidades.PersonaDireccion;

@Stateless
@LocalBean
public class BOPersonaDireccionEJB extends EJBGenerico<PersonaDireccion> implements InterfaceEJBRemote<PersonaDireccion>{
	
	@EJB
	private BOPersonaEJB personaEJB;
	
	@EJB
	private BODireccionEJB direccionEJB;
	
	@Override
	public void crear(PersonaDireccion entidad) {
		
		Persona per = personaEJB.buscar(entidad.getPersona().getId());
		Direccion dir = direccionEJB.buscar(entidad.getDireccion().getId());
		
		if(per != null && dir !=null){
			PersonaDireccion perDir = new PersonaDireccion();
			perDir.setPersona(per);
			perDir.setDireccion(dir);
			dao.crear(perDir);
		}
		
	}

	@Override
	public PersonaDireccion buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(PersonaDireccion entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(PersonaDireccion entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getClase() {
		return PersonaDireccion.class;
	}

	/**
	 * Busca las direcciones de un usuario
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<PersonaDireccion> buscarPersonaDireccion(int idPer, int idDir){
		return dao.ejecutarNamedQuery(PersonaDireccion.BUSCAR_PERSONA_DIRECCION, idPer, idDir);
	}
	
}
