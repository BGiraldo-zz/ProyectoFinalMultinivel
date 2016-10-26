package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaProducto;

@Stateless
public class BOCategoriaProductoEJB extends EJBGenerico<CategoriaProducto> implements InterfaceEJBRemote<CategoriaProducto>{

	@Override
	public Class getClase() {
		return CategoriaProducto.class;
	}

	@Override
	public void crear(CategoriaProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un categoria de producto "
					+ "con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public CategoriaProducto buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(CategoriaProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una categoria del producto"
					+ " con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(CategoriaProducto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un categoria del producto con este codigo " + entidad.getId());
		}
	}


}
