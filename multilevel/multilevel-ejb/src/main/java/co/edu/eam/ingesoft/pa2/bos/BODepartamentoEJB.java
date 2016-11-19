package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Departamento;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Departamento;

@Stateless
public class BODepartamentoEJB extends EJBGenerico<Departamento> implements InterfaceEJBRemote<Departamento>{
	@Override
	public Class getClase() {
		return Departamento.class;
	}

	@Override
	public void crear(Departamento entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Departamento con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Departamento buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Departamento entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Departamento con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Departamento entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Departamento con este codigo " + entidad.getId());
		}
	}


}
