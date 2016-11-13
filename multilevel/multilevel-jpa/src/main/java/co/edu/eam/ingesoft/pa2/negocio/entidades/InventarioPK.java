package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class InventarioPK implements Serializable{

	private int representante;
	
	private int producto;

	public InventarioPK(int representante, int producto) {
		super();
		this.representante = representante;
		this.producto = producto;
	}

	public InventarioPK() {
		
	}

	/**
	 * @return the representante
	 */
	public int getRepresentante() {
		return representante;
	}

	/**
	 * @param representante the representante to set
	 */
	public void setRepresentante(int representante) {
		this.representante = representante;
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
		result = prime * result + representante;
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
		InventarioPK other = (InventarioPK) obj;
		if (producto != other.producto)
			return false;
		if (representante != other.representante)
			return false;
		return true;
	}
	
	
	
}
