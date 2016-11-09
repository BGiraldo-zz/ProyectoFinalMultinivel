package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Venta;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Venta;

@LocalBean
@Stateless
public class BOVentaEJB extends EJBGenerico<Venta> implements InterfaceEJBRemote<Venta>{

	@Override
	public Class getClase() {
		return Venta.class;
	}

	@Override
	public void crear(Venta entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Venta con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Venta buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Venta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Venta con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Venta entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Venta con este codigo " + entidad.getId());
		}
	}


}
