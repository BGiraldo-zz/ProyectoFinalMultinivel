package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.DescripcionPremio;

@Stateless
public class BODescripcionPremioEJB extends EJBGenerico<DescripcionPremio> implements InterfaceEJBRemote<DescripcionPremio> {


	@Override
	public Class getClase() {
		return DescripcionPremio.class;
	}

	@Override
	public void crear(DescripcionPremio entidad) {
		if (buscar(entidad.getPremio().getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Descripcion Premio con este codigo " + entidad.getPremio().getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public DescripcionPremio buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(DescripcionPremio entidad) {
		if (buscar(entidad.getPremio().getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Descripcion Premio con este codigo " + entidad.getPremio().getId());
		}
	}

	@Override
	public void eliminar(DescripcionPremio entidad) {
		if (buscar(entidad.getPremio().getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Descripcion Premio con este codigo " + entidad.getPremio().getId());
		}
	}


}
