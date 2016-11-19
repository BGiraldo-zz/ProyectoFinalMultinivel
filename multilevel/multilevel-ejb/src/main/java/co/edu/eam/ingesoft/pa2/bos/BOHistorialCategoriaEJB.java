package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.HistorialCategoria;

@Stateless
public class BOHistorialCategoriaEJB extends EJBGenerico<HistorialCategoria> implements InterfaceEJBRemote<HistorialCategoria>{

	@Override
	public Class getClase() {
		return HistorialCategoria.class;
	}

	@Override
	public void crear(HistorialCategoria entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Historial Categoria con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public HistorialCategoria buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(HistorialCategoria entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Historial Categoria con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(HistorialCategoria entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Historial Categoria con este codigo " + entidad.getId());
		}
	}
}
