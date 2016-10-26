package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Pais;

@Stateless
public class BOPaisEJB extends EJBGenerico<Pais> implements InterfaceEJBRemote<Pais>{

	@Override
	public Class getClase() {
		return Pais.class;
	}

	@Override
	public void crear(Pais entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Pais con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Pais buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Pais entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Pais con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Pais entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Pais con este codigo " + entidad.getId());
		}
	}


}
