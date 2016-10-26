package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;

@Stateless
public class BOProductoEJB extends EJBGenerico<Producto> implements InterfaceEJBRemote<Producto>{

	@Override
	public Class getClase() {
		return Producto.class;
	}

	@Override
	public void crear(Producto entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Producto con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Producto buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Producto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Producto con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Producto entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Producto con este codigo " + entidad.getId());
		}
	}


}
