package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;

@Stateless
public class BORepresentanteEJB extends EJBGenerico<Representante> implements InterfaceEJBRemote<Representante> {

	@Override
	public Class getClase() {
		return Representante.class;
	}

	@Override
	public void crear(Representante entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Representante con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Representante buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Representante entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Representante con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Representante entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Representante con este codigo " + entidad.getId());
		}
	}


}
