package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.EntregaProducto;

@Stateless
public class BOEntregaProductoEJB extends EJBGenerico<EntregaProducto> implements InterfaceEJBRemote<EntregaProducto>{

	@Override
	public Class getClase() {
		return EntregaProducto.class;
	}

	@Override
	public void crear(EntregaProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Entrega Producto con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public EntregaProducto buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(EntregaProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Entrega Producto con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(EntregaProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Entrega Producto con este codigo " + entidad.getId());
		}
	}
}
