package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.LoginRol;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Rol;
import co.edu.eam.ingesoft.pa2.util.ConstantesNamedQueries;

@Stateless
@LocalBean
public class BORolEJB extends EJBGenerico<Rol> implements InterfaceEJBRemote<Rol>{

	@Override
	public Class getClase() {
		return Rol.class;
	}

	@Override
	public void crear(Rol entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Rol con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Rol buscar(Object pk) {
		Rol r = dao.buscar(pk);
		return r;
	}

	@Override
	public void editar(Rol entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Rol con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(Rol entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Rol con este codigo " + entidad.getId());
		}
	}
	
	/**
	 * Busca los roles de un login de un usuario
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Rol> buscarRolesLogin(int idLogin){
		return dao.ejecutarNamedQuery(LoginRol.BUSCAR_LOGIN_ROLES, idLogin);
	}


}
