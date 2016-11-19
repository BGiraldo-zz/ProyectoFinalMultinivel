package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.DescripcionMeta;

@Stateless
public class BODescripcionMeta extends EJBGenerico<DescripcionMeta> implements InterfaceEJBRemote<DescripcionMeta> {

	@Override
	public Class getClase() {
		return DescripcionMeta.class;
	}

	@Override
	public void crear(DescripcionMeta entidad) {
		if (buscar(entidad.getMeta().getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Descripcion Meta con este codigo " + entidad.getMeta().getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public DescripcionMeta buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(DescripcionMeta entidad) {
		if (buscar(entidad.getMeta().getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Descripcion Meta con este codigo " + entidad.getMeta().getId());
		}
	}

	@Override
	public void eliminar(DescripcionMeta entidad) {
		if (buscar(entidad.getMeta().getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Descripcion Meta con este codigo " + entidad.getMeta().getId());
		}
	}
	
}
