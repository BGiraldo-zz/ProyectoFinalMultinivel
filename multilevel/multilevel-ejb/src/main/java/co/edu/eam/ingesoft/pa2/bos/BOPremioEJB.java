package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Premio;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Premio;

@Stateless
public class BOPremioEJB extends EJBGenerico<Premio> implements InterfaceEJBRemote<Premio>{

	@Override
	public Class getClase() {
		return Premio.class;
	}

	@Override
	public void crear(Premio entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Premio con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Premio buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Premio entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Premio con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Premio entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Premio con este codigo " + entidad.getId());
		}
	}


}
