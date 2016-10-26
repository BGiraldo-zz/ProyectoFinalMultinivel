package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("ControladorManejoPedidos")
@ViewScoped
// @ExceptionLogger
public class ControladorManejoPedidos implements Serializable {

	private Object pedido;

	private List<Object> pedidos;

	public void revisarPedido() {

	}

	public void aprobarPedido() {

	}

	public void negarPedido() {

	}

	/**
	 * @return the pedido
	 */
	public Object getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(Object pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the pedidos
	 */
	public List<Object> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos
	 *            the pedidos to set
	 */
	public void setPedidos(List<Object> pedidos) {
		this.pedidos = pedidos;
	}

}
