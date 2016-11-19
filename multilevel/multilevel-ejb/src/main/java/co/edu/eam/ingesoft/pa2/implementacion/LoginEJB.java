package co.edu.eam.ingesoft.pa2.implementacion;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Login;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Persona;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;
import co.edu.eam.ingesoft.pa2.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.util.MD5Util;


/**
 * 
 * @author Jairo Andres
 *
 */
@LocalBean
@Stateless
public class LoginEJB extends EJBGenerico<Persona> {

	@Override
	public Class getClase() {
		return Persona.class;
	}

	/**
	 * Metodo para buscar un usuario
	 * 
	 * @param user
	 *            el usuario a buscar
	 * @param pass
	 *            la contrasenia del usuario
	 * @return el usuario si lo encuentra, de lo contrario excepcion
	 */
	public Representante buscarUsuario(String user, String pass) {
		//pass = MD5Util.code(pass);
		List<Representante> lista = dao.ejecutarNamedQuery(Login.BUSCAR_POR_USER_PASS, user, pass);
		
		if (!lista.isEmpty()) {
			return lista.get(0);
		} else {  
			return null;
		}
		
	}

}
