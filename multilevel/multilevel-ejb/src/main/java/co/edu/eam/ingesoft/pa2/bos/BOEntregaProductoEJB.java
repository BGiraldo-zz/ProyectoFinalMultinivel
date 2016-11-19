package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.DetallePedido;

@Stateless
@LocalBean
public class BOEntregaProductoEJB extends EJBGenerico<DetallePedido> implements InterfaceEJBRemote<DetallePedido>{

	@Override
	public Class getClase() {
		return DetallePedido.class;
	}

	@Override
	public void crear(DetallePedido entidad) {
		if (buscar(entidad.getPedido().getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Entrega Producto con este codigo " + entidad.getPedido().getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public DetallePedido buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(DetallePedido entidad) {
		if (buscar(entidad.getPedido().getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Entrega Producto con este codigo " + entidad.getPedido().getId());
		}
	}

	@Override
	public void eliminar(DetallePedido entidad) {
		if (buscar(entidad.getPedido().getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Entrega Producto con este codigo " + entidad.getPedido().getId());
		}
	}
}
