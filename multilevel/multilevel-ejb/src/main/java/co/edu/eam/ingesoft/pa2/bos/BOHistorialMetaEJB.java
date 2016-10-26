package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.HistorialMeta;

@Stateless
public class BOHistorialMetaEJB extends EJBGenerico<HistorialMeta> implements InterfaceEJBRemote<HistorialMeta>{

	@Override
	public Class getClase() {
		return HistorialMeta.class;
	}

	@Override
	public void crear(HistorialMeta entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Historial Meta con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public HistorialMeta buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(HistorialMeta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Historial Meta con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(HistorialMeta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Historial Meta con este codigo " + entidad.getId());
		}
	}

}
