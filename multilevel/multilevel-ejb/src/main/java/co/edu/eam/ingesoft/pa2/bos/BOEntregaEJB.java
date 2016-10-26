package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Entrega;

@Stateless
public class BOEntregaEJB extends EJBGenerico<Entrega> implements InterfaceEJBRemote<Entrega>{
	@Override
	public Class getClase() {
		return Entrega.class;
	}

	@Override
	public void crear(Entrega entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Entrega con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Entrega buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Entrega entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Entrega con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Entrega entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Entrega con este codigo " + entidad.getId());
		}
	}

}
