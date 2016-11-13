package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.DetalleVenta;

@Stateless
public class BODetalleVentasEJB extends EJBGenerico<DetalleVenta> implements InterfaceEJBRemote<DetalleVenta> {

	@Override
	public Class getClase() {
		return DetalleVenta.class;
	}

	@Override
	public void crear(DetalleVenta entidad) {
		if (buscar(entidad.getVenta().getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Detalle Venta con este codigo " + entidad.getVenta().getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public DetalleVenta buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(DetalleVenta entidad) {
		if (buscar(entidad.getVenta().getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Detalle Venta con este codigo " + entidad.getVenta().getId());
		}
	}

	@Override
	public void eliminar(DetalleVenta entidad) {
		if (buscar(entidad.getVenta().getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Detalle Venta con este codigo " + entidad.getVenta().getId());
		}
	}
}
