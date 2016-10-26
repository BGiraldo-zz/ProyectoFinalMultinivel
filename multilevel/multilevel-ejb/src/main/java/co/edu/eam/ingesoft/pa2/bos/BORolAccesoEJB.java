package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.RolAcceso;

@Stateless
public class BORolAccesoEJB extends EJBGenerico<RolAcceso> implements InterfaceEJBRemote<RolAcceso> {

	@Override
	public void crear(RolAcceso entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RolAcceso buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(RolAcceso entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(RolAcceso entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return RolAcceso.class;
	}

}
