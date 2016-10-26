package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;

@Stateless
public class BOCatalogoEJB extends EJBGenerico<Catalogo> implements InterfaceEJBRemote<Catalogo>{

	@Override
	public Class getClase() {
		return Catalogo.class;
	}

	@Override
	public void crear(Catalogo entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un catalogo con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Catalogo buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Catalogo entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un catalogo con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Catalogo entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un catalogo con este codigo " + entidad.getId());
		}
	}


}
