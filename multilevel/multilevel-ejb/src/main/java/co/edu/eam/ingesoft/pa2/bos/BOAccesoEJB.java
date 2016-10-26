package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Acceso;

@Stateless
public class BOAccesoEJB extends EJBGenerico<Acceso> implements InterfaceEJBRemote<Acceso> {

	@Override
	public Class getClase() {
		return Acceso.class;
	}

	@Override
	public void crear(Acceso entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Acceso con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Acceso buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Acceso entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Acceso con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Acceso entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Acceso con este codigo " + entidad.getId());
		}
	}


}
