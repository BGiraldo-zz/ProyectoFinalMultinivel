package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Rol;

@Stateless
public class BORolEJB extends EJBGenerico<Rol> implements InterfaceEJBRemote<Rol>{

	@Override
	public Class getClase() {
		return Rol.class;
	}

	@Override
	public void crear(Rol entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Rol con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Rol buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Rol entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Rol con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Rol entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Rol con este codigo " + entidad.getId());
		}
	}


}
