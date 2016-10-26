package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.TipoPago;

@Stateless
public class BOTipoPagoEJB extends EJBGenerico<TipoPago> implements InterfaceEJBRemote<TipoPago>{

	@Override
	public Class getClase() {
		return TipoPago.class;
	}

	@Override
	public void crear(TipoPago entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Tipo Pago con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public TipoPago buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(TipoPago entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Tipo Pago con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(TipoPago entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Tipo Pago con este codigo " + entidad.getId());
		}
	}

}
