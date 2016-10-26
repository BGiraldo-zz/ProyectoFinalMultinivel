package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPremioENUM;

@Entity
@Table(name="PREMIOS")
public class Premio implements Serializable{

	@Id
	@Column(name="PREMIO_ID", length=7, nullable=false)
	private int id;
	
	@Column(name="NOMBRE", length=60,nullable=false)
	private String nombre;
	
	@Column(name="VALOR", length=12, nullable=false)
	private double valor;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="TIPO_PREMIO", length=60, nullable=false)
	private TipoPremioENUM tipoPremio;

	/**
	 * @param id
	 * @param nombre
	 * @param valor
	 * @param tipoPremio
	 */
	public Premio(int id, String nombre, double valor, TipoPremioENUM tipoPremio) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.tipoPremio = tipoPremio;
	}

	/**
	 * 
	 */
	public Premio() {
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
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the tipoPremio
	 */
	public TipoPremioENUM getTipoPremio() {
		return tipoPremio;
	}

	/**
	 * @param tipoPremio the tipoPremio to set
	 */
	public void setTipoPremio(TipoPremioENUM tipoPremio) {
		this.tipoPremio = tipoPremio;
	}
	
	
	
}
