package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CatalogoProducto;

@Stateless
public class BOCatalogoProductoEJB extends EJBGenerico<CatalogoProducto> implements InterfaceEJBRemote<CatalogoProducto>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public Class getClase() {
		return CatalogoProducto.class;
	}

	@Override
	public void crear(CatalogoProducto entidad) {
		if (buscar(entidad.get) != null) {
			throw new ExcepcionFuncional("Ya existe un Catalogo Producto con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public CatalogoProducto buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(CatalogoProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Catalogo Producto con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(CatalogoProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Catalogo Producto con este codigo " + entidad.getId());
		}
	}
*/
}
