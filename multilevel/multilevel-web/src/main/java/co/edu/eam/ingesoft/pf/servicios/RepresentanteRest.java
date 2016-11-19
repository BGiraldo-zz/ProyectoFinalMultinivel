package co.edu.eam.ingesoft.pf.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.bos.BOInventarioEJB;
import co.edu.eam.ingesoft.pa2.bos.BOProductoEJB;
import co.edu.eam.ingesoft.pa2.bos.BORepresentanteEJB;
import co.edu.eam.ingesoft.pa2.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.dto.pedidoDTO;
import co.edu.eam.ingesoft.pa2.dto.pedidolDTO;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Inventario;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;

@Path("/representante")
public class RepresentanteRest {

	@EJB
	private BOProductoEJB proE;
	@EJB
	private BORepresentanteEJB reE;

	@EJB
	private BOInventarioEJB invEJB;

	@POST
	@Path("/inventario")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarInventario(@FormParam(value = "ced") int cedula) {
		List<Inventario> inv = invEJB.listarInventario(cedula);
		if (inv != null) {
			return new RespuestaDTO(inv);
		}
		return new RespuestaDTO(null, "no hay inventarios", "-1");

	}

	// @POST
	// @Path("/productos")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// @Produces(MediaType.APPLICATION_JSON)
	// public RespuestaDTO listarPro(@FormParam(value = "ced") int cedula) {
	//
	// List<Producto> u = proE.listarProductos();
	// if (u != null) {
	//
	// return new RespuestaDTO(u);
	// } else {
	// return new RespuestaDTO(null, "no hay inventario", "-1");
	// }
	// }
	//

	@POST
	@Path("/editarprecio")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO editaPrecio(@FormParam(value = "re") int re, @FormParam(value = "idpro") int idpro,
			@FormParam(value = "precio") double pre) {

		// if (in != null) {
		//
		// return new RespuestaDTO(true);
		// } else {
		// return new RespuestaDTO(null, "no hay inventario", "-1");
		// }
		return new RespuestaDTO(true);
	}

	@POST
	@Path("/productos")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarProductos() {

		List<Producto> u = proE.listarProductos();
		if (u != null) {

			return new RespuestaDTO(u);
		} else {
			return new RespuestaDTO(null, "no hay inventario", "-1");
		}
	}

	@POST
	@Path("/pedido")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO pedidos(@FormParam(value = "id") int id, @FormParam(value = "idpro") int idpro,
			@FormParam(value = "cant") int cant) {
		if (id != 0 && idpro != 0 && cant != 0) {
			System.out.println(id+"--"+idpro+"--"+cant);
			return new RespuestaDTO(true);
		}
		return new RespuestaDTO(null, "error", "-1");

	}
	
	@POST
	@Path("/pedidolist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO pedidoslist(pedidoDTO pedidollegue) {
		
			if (pedidollegue.getPedido().size()==0) {
				return new RespuestaDTO(null, "error", "-1");
			}
			
			return new RespuestaDTO(true);
		

	}

}
