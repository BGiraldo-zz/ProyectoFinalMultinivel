package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Login;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Persona;
import co.edu.eam.ingesoft.pa2.util.ConstantesNamedQueries;

@Stateless
@LocalBean
public class BOLoginEJB  extends EJBGenerico<Login> implements InterfaceEJBRemote<Login>{


	@Override
	public Class getClase() {
		return Login.class;
	}

	@Override
	public void crear(Login entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Login con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Login buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Login entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Login con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Login entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Login con este codigo " + entidad.getId());
		}
	}

	/**
	 * Busca un login por user y pass
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public Login buscarLoginUserPass(String user, String pass){
		try{
			Login login = dao.ejecutarQuery(Login.BUSCAR_POR_USER_PASS, user,pass);
			return login;
		}catch(NoResultException nre){
			JOptionPane.showMessageDialog(null, "NAAAAAAAAAAAAAA");
		}
	  return null;
	}

}
