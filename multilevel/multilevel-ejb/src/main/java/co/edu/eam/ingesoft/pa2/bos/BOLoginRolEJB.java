package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.LoginRol;

@Stateless
public class BOLoginRolEJB extends EJBGenerico<LoginRol> implements InterfaceEJBRemote<LoginRol>{
 
	@Override
	public void crear(LoginRol entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoginRol buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(LoginRol entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(LoginRol entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getClase() {
		return LoginRol.class;
	}

}
