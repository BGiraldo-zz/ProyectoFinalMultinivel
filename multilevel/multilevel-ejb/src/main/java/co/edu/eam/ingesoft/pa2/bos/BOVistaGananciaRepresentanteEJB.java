package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.VistaGananciaRepresentante;

@Stateless
public class BOVistaGananciaRepresentanteEJB extends EJBGenerico<VistaGananciaRepresentante> implements InterfaceEJBRemote<VistaGananciaRepresentante>{

	@Override
	public Class getClase() {
		return VistaGananciaRepresentante.class;
	}

	@Override
	public void crear(VistaGananciaRepresentante entidad) {
		if (buscar(entidad.getRepresentante().getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Vista Ganancia Representante con este codigo " + entidad.getRepresentante().getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public VistaGananciaRepresentante buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(VistaGananciaRepresentante entidad) {
		if (buscar(entidad.getRepresentante().getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Vista Ganancia Representante con este codigo " + entidad.getRepresentante().getId());
		}
	}

	@Override
	public void eliminar(VistaGananciaRepresentante entidad) {
		if (buscar(entidad.getRepresentante().getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Vista Ganancia Representante con este codigo " + entidad.getRepresentante().getId());
		}
	}
}
