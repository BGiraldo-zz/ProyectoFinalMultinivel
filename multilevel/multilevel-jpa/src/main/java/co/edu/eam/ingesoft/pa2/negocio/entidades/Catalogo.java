package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOGOS")
@NamedQueries({@NamedQuery(name=Catalogo.LISTAR_CATALOGOS,
query="SELECT c FROM Catalogo c")})
public class Catalogo implements Serializable {

	public static final String LISTAR_CATALOGOS = "Catalogo.listarCatalogos";
	
	@Id
	@Column(name = "CATALOGO_ID", length = 12, nullable = false)
	private int id;

	@Column(name = "CANTIDAD_PRODUCTOS", length = 12, nullable = false)
	private int cantidadProductos;

	@Column(name = "NOMBRE", nullable = false, length = 60)
	private String nombre;

	/**
	 * @param id
	 * @param cantidadProductos
	 * @param nombre
	 */
	public Catalogo(int id, int cantidadProductos, String nombre) {
		this.id = id;
		this.cantidadProductos = cantidadProductos;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public Catalogo() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cantidadProductos
	 */
	public int getCantidadProductos() {
		return cantidadProductos;
	}

	/**
	 * @param cantidadProductos the cantidadProductos to set
	 */
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidadProductos;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Catalogo other = (Catalogo) obj;
		if (cantidadProductos != other.cantidadProductos)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	

}
