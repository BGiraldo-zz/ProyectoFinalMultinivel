package co.edu.eam.ingesoft.pf.servicios;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.dto.LoginOutDTO;
import co.edu.eam.ingesoft.pa2.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.implementacion.LoginEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Login;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Persona;




@Path("/login")
public class LoginRest {

	/**
	 * EJB de login
	 */
	@EJB
	private LoginEJB loginEJB;

	/**
	 * EJB de acceso rol
	 */
	

	/**
	 * Map de tokens
	 */
	public static Map<String, Integer> tokens = new HashMap<>();

	/**
	 * servicio rest para verificar usuario
	 * 
	 * @param usuario
	 *            el usuario
	 * @param contrasenia
	 *            la contrasenia del usuairo
	 * @return dto con mensaje de error u objeto
	 */
	@POST
	@Path("/verificar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(@FormParam(value = "usuario") String usuario,
			@FormParam(value = "contrasenia") String contrasenia) {
		Login u = loginEJB.buscarUsuario(usuario, contrasenia);
		if (u != null) {
			String token = UUID.randomUUID().toString();
			tokens.put(token, u.getId());
			LoginOutDTO obj = new LoginOutDTO(token, usuario, u.getId() + "");
			return new RespuestaDTO(obj);
		} else {
			return new RespuestaDTO(null, "Usuario o contrase�a incorrectos", "-1");
		}
	}

//	/**
//	 * servicio que verifica los roles y accesos de un usuario
//	 * 
//	 * @param usuario
//	 *            el usuario
//	 * @return dto con mensaje de error u objetos
//	 */
//	@POST
//	@Path("/accesos")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.APPLICATION_JSON)
//	@Secured
//	public RespuestaDTO accesos(@FormParam(value = "usuario") String usuario) {
//		List<Rol> roles = accesoRolEJB.listarRoles(usuario);
//		List<Acceso> accesos = accesoRolEJB.listarAccesos();
//		if (!roles.isEmpty()) {
//			AccesoRolDTO obj = new AccesoRolDTO(accesos, roles, usuario);
//			return new RespuestaDTO(obj);
//		} else {
//			return new RespuestaDTO(null, "Usted no cuenta con accesos asignados", "-1");
//		}
//	}

}
