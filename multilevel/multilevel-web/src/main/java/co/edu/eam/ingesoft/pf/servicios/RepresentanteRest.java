package co.edu.eam.ingesoft.pf.servicios;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.bos.BOEntregaProductoEJB;
import co.edu.eam.ingesoft.pa2.bos.BOInventarioEJB;
import co.edu.eam.ingesoft.pa2.bos.BOPedidoEJB;
import co.edu.eam.ingesoft.pa2.bos.BOProductoEJB;
import co.edu.eam.ingesoft.pa2.bos.BORepresentanteEJB;
import co.edu.eam.ingesoft.pa2.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.dto.pedidoDTO;
import co.edu.eam.ingesoft.pa2.dto.pedidolDTO;
import co.edu.eam.ingesoft.pa2.negocio.entidades.DetallePedido;
import co.edu.eam.ingesoft.pa2.negocio.entidades.DetallePedidoPK;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Inventario;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Pedido;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.MetodoPagoENUM;

@Path("/representante")
public class RepresentanteRest {

	@EJB
	private BOProductoEJB proE;
	@EJB
	private BORepresentanteEJB reE;

	@EJB
	private BOInventarioEJB invEJB;

	@EJB
	private BOPedidoEJB pedidoejb;

	@EJB
	private BOEntregaProductoEJB depedejb;

	@POST
	@Path("/inventario")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarInventario(@FormParam(value = "ced") int cedula) {
		List<Inventario> inv = invEJB.listarInventario(cedula);
		if (inv.size() != 0) {
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

		Calendar cal = Calendar.getInstance();
		Date date = (Date) cal.getTime();
		Representante re = reE.buscar(id);
		Producto pro = proE.buscar(idpro);
		long iid =  System.currentTimeMillis() / 10;
		int idd = (int)iid;
		Pedido pe = new Pedido(idd, 'P', date, date, MetodoPagoENUM.CONTADO, pro.getPrecioVenta() * cant,
				pro.getPuntos() * cant, re);
		pedidoejb.crear(pe);
		Pedido ped = pedidoejb.buscar(pe.getId());

		DetallePedido de = new DetallePedido();
		// pe, pro, cant, pro.getPuntos(), pro.getPrecioVenta()
		de.setPedido(ped);
		de.setProducto(pro);
		de.setCantidad(cant);
		de.setPuntos(pro.getPuntos());
		de.setPrecioProducto(pro.getPrecioVenta());

		depedejb.crear(de);

		return new RespuestaDTO(true);
		// return new RespuestaDTO(true);
		//
		// return new RespuestaDTO(null, "error", "-1");

	}

	@POST
	@Path("/pedidolist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO pedidoslist(pedidoDTO pedidollegue) {

		if (pedidollegue.getPedido().size() == 0) {
			return new RespuestaDTO(null, "error", "-1");
		}

		Calendar cal = Calendar.getInstance();
		Date date = (Date) cal.getTime();
		for (int i = 0; i < pedidollegue.getPedido().size(); i++) {

			pedidoDTO.ItemDTO pee = pedidollegue.getPedido().get(i);
			// Representante re = reE.buscar(pee.)
			// Pedido pe = new Pedido(id,"P", date, null, MetodoPagoENUM.CONTADO
			// , pee.getPrecio(),
			// pee.getProducto().getPuntos()*pee.getCantidad(), representante)

		}

		return new RespuestaDTO(true);

	}

}
