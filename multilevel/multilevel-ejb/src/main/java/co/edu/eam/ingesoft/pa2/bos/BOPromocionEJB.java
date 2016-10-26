package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;

@Stateless
public class BOPromocionEJB extends EJBGenerico<Promocion> implements InterfaceEJBRemote<Promocion>{

	@Override
	public Class getClase() {
		return Promocion.class;
	}

	@Override
	public void crear(Promocion entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Promocion con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Promocion buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Promocion entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Promocion con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Promocion entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Promocion con este codigo " + entidad.getId());
		}
	}

}
