package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Cuota;

@Stateless
public class BOCuotaEJB extends EJBGenerico<Cuota> implements InterfaceEJBRemote<Cuota>{

	@Override
	public Class getClase() {
		return Cuota.class;
	}

	@Override
	public void crear(Cuota entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Cuota con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Cuota buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Cuota entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Cuota con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Cuota entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Cuota con este codigo " + entidad.getId());
		}
	}

}
