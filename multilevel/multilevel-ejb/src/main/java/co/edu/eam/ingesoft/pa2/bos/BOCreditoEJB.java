package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Credito;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Credito;

@Stateless
public class BOCreditoEJB extends EJBGenerico<Credito> implements InterfaceEJBRemote<Credito> {

	@Override
	public Class getClase() {
		return Credito.class;
	}

	@Override
	public void crear(Credito entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Credito con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Credito buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Credito entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Credito con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Credito entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Credito con este codigo " + entidad.getId());
		}
	}

}
