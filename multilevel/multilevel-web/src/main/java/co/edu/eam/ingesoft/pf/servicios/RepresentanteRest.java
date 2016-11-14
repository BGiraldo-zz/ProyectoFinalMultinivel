package co.edu.eam.ingesoft.pf.servicios;


import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import co.edu.eam.ingesoft.pa2.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.dto.invDTO;
import co.edu.eam.ingesoft.pa2.implementacion.InventarioEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Inventario;


@Path("/representante")
public class RepresentanteRest {
	
	@EJB
	private InventarioEJB invEjb;
	
	
	@POST
	@Path("/inventario")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarInventario(@FormParam(value = "ced") int cedula) {
		
		List<invDTO> u = invEjb.listarInventario(cedula);
		if (u != null) {
			
			return new RespuestaDTO(u);
		} else {
			return new RespuestaDTO(null, "no hay inventario", "-1");
		}
	}
//	
	
//	@POST
//	@Path("/editarprecio")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.APPLICATION_JSON)
//	public RespuestaDTO editaPrecio(@FormParam(value = "idre") int idpro,@FormParam(value = "idpro")double idre,@FormParam(value = "precio")double precio) {
//		
//		if (u != null) {
//			
//			return new RespuestaDTO(true);
//		} else {
//			return new RespuestaDTO(null, "no hay inventario", "-1");
//		}
//	}
}
