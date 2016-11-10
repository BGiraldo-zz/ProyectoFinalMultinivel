package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class DetallePedidoPK implements Serializable{

	private int pedido;
	
	private int producto;

	public DetallePedidoPK(int pedido, int producto) {
		super();
		this.pedido = pedido;
		this.producto = producto;
	}

	public DetallePedidoPK() {
		
	}

	/**
	 * @return the pedido
	 */
	public int getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the producto
	 */
	public int getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(int producto) {
		this.producto = producto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pedido;
		result = prime * result + producto;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallePedidoPK other = (DetallePedidoPK) obj;
		if (pedido != other.pedido)
			return false;
		if (producto != other.producto)
			return false;
		return true;
	}
	
	
	
	
}
