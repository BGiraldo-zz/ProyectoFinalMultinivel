package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Meta;

@Stateless
public class BOMetaEJB extends EJBGenerico<Meta> implements InterfaceEJBRemote<Meta>{

	@Override
	public Class getClase() {
		return Meta.class;
	}

	@Override
	public void crear(Meta entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Meta con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Meta buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Meta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Meta con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Meta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Meta con este codigo " + entidad.getId());
		}
	}


}
