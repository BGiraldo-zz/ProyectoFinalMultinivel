package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA_REPRESENTANTES")
@NamedQueries({@NamedQuery(name=CategoriaRepresentante.LISTAR_CATEGORIA,
query="SELECT cr FROM CategoriaRepresentante cr")})
public class CategoriaRepresentante implements Serializable{

	public static final String LISTAR_CATEGORIA = "CategoriaRepresentante.listarCategorias";
	
	@Id
	@Column(name="CATEGORIA_REPRESENTANTES_ID", length=12, nullable=false)
	private int id;
	
	@Column(name="NOMBRE", length=60, nullable=false)
	private String nombre;
	
	@Column(name="RANGO_INICIAL", length=12, nullable=false)
	private int rangoInicial;
	
	@Column(name="RANGO_FINAL", length=12, nullable=false)
	private int rangoFinal;
	
	@Column(name="BONIFICACION", length=3, nullable=false)
	private int bonificacion;

	/**
	 * @param id
	 * @param nombre
	 * @param rangoInicial
	 * @param rangoFinal
	 * @param bonificacion
	 */
	public CategoriaRepresentante(int id, String nombre, int rangoInicial, int rangoFinal, int bonificacion) {
		this.id = id;
		this.nombre = nombre;
		this.rangoInicial = rangoInicial;
		this.rangoFinal = rangoFinal;
		this.bonificacion = bonificacion;
	}

	/**
	 * 
	 */
	public CategoriaRepresentante() {
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

	/**
	 * @return the rangoInicial
	 */
	public int getRangoInicial() {
		return rangoInicial;
	}

	/**
	 * @param rangoInicial the rangoInicial to set
	 */
	public void setRangoInicial(int rangoInicial) {
		this.rangoInicial = rangoInicial;
	}

	/**
	 * @return the rangoFinal
	 */
	public int getRangoFinal() {
		return rangoFinal;
	}

	/**
	 * @param rangoFinal the rangoFinal to set
	 */
	public void setRangoFinal(int rangoFinal) {
		this.rangoFinal = rangoFinal;
	}

	/**
	 * @return the bonificacion
	 */
	public int getBonificacion() {
		return bonificacion;
	}

	/**
	 * @param bonificacion the bonificacion to set
	 */
	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ""+nombre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bonificacion;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + rangoFinal;
		result = prime * result + rangoInicial;
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
		CategoriaRepresentante other = (CategoriaRepresentante) obj;
		if (bonificacion != other.bonificacion)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (rangoFinal != other.rangoFinal)
			return false;
		if (rangoInicial != other.rangoInicial)
			return false;
		return true;
	}
	
	
	
}
