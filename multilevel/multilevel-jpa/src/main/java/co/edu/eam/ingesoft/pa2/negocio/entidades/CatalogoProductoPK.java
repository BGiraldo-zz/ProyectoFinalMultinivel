package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

public class CatalogoProductoPK implements Serializable{

	private int catalogo;
	
	private int producto;

	/**
	 * @param catalogo
	 * @param producto
	 */
	public CatalogoProductoPK(int catalogo, int producto) {
		this.catalogo = catalogo;
		this.producto = producto;
	}

	/**
	 * 
	 */
	public CatalogoProductoPK() {
	}

	/**
	 * @return the catalogo
	 */
	public int getCatalogo() {
		return catalogo;
	}

	/**
	 * @param catalogo the catalogo to set
	 */
	public void setCatalogo(int catalogo) {
		this.catalogo = catalogo;
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
		result = prime * result + catalogo;
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
		CatalogoProductoPK other = (CatalogoProductoPK) obj;
		if (catalogo != other.catalogo)
			return false;
		if (producto != other.producto)
			return false;
		return true;
	}
	
	
	
	
}
