package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.bos.BOPedidoEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Pedido;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("ControladorManejoPedidos")
@ViewScoped
@ExceptionLogger
public class ControladorManejoPedidos implements Serializable {

	private Pedido pedido;

	private List<Pedido> pedidos;
	
	@EJB
	private BOPedidoEJB pedidoEJB;
	
	
	@PostConstruct
	public void inicializar(){
		pedido = new Pedido();
		pedidos = pedidoEJB.listarPedidosPendientes();
	
	}

	public void revisarPedido() {
    	Pedido p = pedidoEJB.buscar(pedido.getId());
		pedido.setEstado(p.getEstado());
		pedido.setFechaEntrega(p.getFechaEntrega());
		pedido.setFechaPedido(p.getFechaPedido());
		pedido.setId(p.getId());
		pedido.setMetodoPago(p.getMetodoPago());
		pedido.setPrecio(p.getPrecio());
		pedido.setPuntos(p.getPuntos());
		pedido.setRepresentante(p.getRepresentante());	
	}

	/**
	 * Aprueba un pedido cambiandole el estado a 'A'
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void aprobarPedido() {
		Pedido p = pedidoEJB.buscar(pedido.getId());
	    p.setEstado('A');
	    pedidoEJB.editar(p);
		Messages.addGlobalInfo("El pedido ha sido aprobado correctamente");
		inicializar();
	}

	/**
	 * Niega un pedido cambiandole el estado a 'N'
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void negarPedido() {
		Pedido p = pedidoEJB.buscar(pedido.getId());
	    p.setEstado('N');
	    pedidoEJB.editar(p);
		Messages.addGlobalInfo("El pedido ha sido Negado correctamente");
		inicializar();
	}
	
	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	/**
	 * @return the pedidoEJB
	 */
	public BOPedidoEJB getPedidoEJB() {
		return pedidoEJB;
	}

	/**
	 * @param pedidoEJB the pedidoEJB to set
	 */
	public void setPedidoEJB(BOPedidoEJB pedidoEJB) {
		this.pedidoEJB = pedidoEJB;
	}

	/**
	 * @return the pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos the pedidos to set
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
	


	
	
}
