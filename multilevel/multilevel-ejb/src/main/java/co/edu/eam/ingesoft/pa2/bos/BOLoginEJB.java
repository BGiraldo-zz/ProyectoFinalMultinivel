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
public class BOLoginEJB extends EJBGenerico<Login> implements InterfaceEJBRemote<Login> {

	@Override
	public Class getClase() {
		return Login.class;
	}

	@Override
	public void crear(Login entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Login con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Login buscar(Object pk) {
		Login l = dao.buscar(pk);
		if (l != null) {
			return l;
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Login con este codigo " + pk);

		}
	}

	@Override
	public void editar(Login entidad) {
		dao.editar(entidad);
	}

	@Override
	public void eliminar(Login entidad) {
		dao.borrar(entidad);
	}

	/**
	 * Busca un login por user y pass
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public Login buscarLoginUserPass(String user, String pass) {
		try {
			Login login = dao.ejecutarQuery(Login.BUSCAR_POR_USUARIO_PASS, user, pass);
			return login;
		} catch (Exception nre) {
			throw new ExcepcionFuncional("El usuario o la contraseña indicados son Incorrectos");
		}
	}

}
