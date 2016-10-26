package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.EmpresaDistribuidora;

@Stateless
public class BOEmpresaDistribuidoraEJB extends EJBGenerico<EmpresaDistribuidora> implements InterfaceEJBRemote<EmpresaDistribuidora> {

	@Override
	public Class getClase() {
		return EmpresaDistribuidora.class;
	}

	@Override
	public void crear(EmpresaDistribuidora entidad) {
		if (buscar(entidad.getNIF()) != null) {
			throw new ExcepcionFuncional("Ya existe un EmpresaDistribuidora con este codigo " + entidad.getNIF());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public EmpresaDistribuidora buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(EmpresaDistribuidora entidad) {
		if (buscar(entidad.getNIF()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un EmpresaDistribuidora con este codigo " + entidad.getNIF());
		}
	}

	@Override
	public void eliminar(EmpresaDistribuidora entidad) {
		if (buscar(entidad.getNIF()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un EmpresaDistribuidora con este codigo " + entidad.getNIF());
		}
	}


}
