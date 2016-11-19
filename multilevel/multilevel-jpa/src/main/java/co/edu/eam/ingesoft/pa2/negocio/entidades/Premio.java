package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPremioENUM;

@Entity
@Table(name="PREMIOS")
@NamedQueries({@NamedQuery(name=Premio.LISTAR_PREMIOS,
query = "SELECT p FROM Premio p")})
public class Premio implements Serializable{

	public static final String LISTAR_PREMIOS = "Premio.listarPremios";
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipoPremio == null) ? 0 : tipoPremio.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Premio other = (Premio) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipoPremio != other.tipoPremio)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	
	
	
	
}
