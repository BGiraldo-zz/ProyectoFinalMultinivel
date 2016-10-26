package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.DescripcionProducto;

@Stateless
public class BODescripcionProductoEJB extends EJBGenerico<DescripcionProducto>  implements InterfaceEJBRemote<DescripcionProducto> {

	@Override
	public Class getClase() {
		return DescripcionProducto.class;
	}

	@Override
	public void crear(DescripcionProducto entidad) {
		if (buscar(entidad.getProducto().getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Descripcion Producto con este codigo " + entidad.getProducto().getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public DescripcionProducto buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(DescripcionProducto entidad) {
		if (buscar(entidad.getProducto().getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Descripcion Producto con este codigo " + entidad.getProducto().getId());
		}
	}

	@Override
	public void eliminar(DescripcionProducto entidad) {
		if (buscar(entidad.getProducto().getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Descripcion Producto con este codigo " + entidad.getProducto().getId());
		}
	}

}
