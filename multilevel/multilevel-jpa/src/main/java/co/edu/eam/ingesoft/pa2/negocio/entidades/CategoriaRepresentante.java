package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA_REPRESENTANTES")
public class CategoriaRepresentante implements Serializable{

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
	
	
}
