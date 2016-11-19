package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class DetalleVentaPK implements Serializable{

	private int venta;
	
	private int producto;

	public DetalleVentaPK(int venta, int producto) {
		super();
		this.venta = venta;
		this.producto = producto;
	}

	public DetalleVentaPK() {
		
	}

	/**
	 * @return the venta
	 */
	public int getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(int venta) {
		this.venta = venta;
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
		result = prime * result + producto;
		result = prime * result + venta;
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
		DetalleVentaPK other = (DetalleVentaPK) obj;
		if (producto != other.producto)
			return false;
		if (venta != other.venta)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
