package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROMOCIONES")
@NamedQueries({@NamedQuery(name=Promocion.LISTAR_PROMOCIONES,
query="SELECT p FROM Promocion p")})
public class Promocion implements Serializable {

	public static final String LISTAR_PROMOCIONES = "Promocion.listarPromociones";
	
	@Id
	@Column(name="PROMOCION_ID", length=12, nullable=false)
	private int id;
	
	@Column(name="DESCUENTO", length=4, nullable=false)
	private int descuento;
	
	@Column(name="FECHA_INICIAL", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaInicial;
	
	@Column(name="FECHA_FINAL", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaFinal;

	/**
	 * @param id
	 * @param descuento
	 * @param fechaInicial
	 * @param fechaFinal
	 */
	public Promocion(int id, int descuento, Date fechaInicial, Date fechaFinal) {
		this.id = id;
		this.descuento = descuento;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	/**
	 * 
	 */
	public Promocion() {
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
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return descuento+" "+"%";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + descuento;
		result = prime * result + ((fechaFinal == null) ? 0 : fechaFinal.hashCode());
		result = prime * result + ((fechaInicial == null) ? 0 : fechaInicial.hashCode());
		result = prime * result + id;
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
		Promocion other = (Promocion) obj;
		if (descuento != other.descuento)
			return false;
		if (fechaFinal == null) {
			if (other.fechaFinal != null)
				return false;
		} else if (!fechaFinal.equals(other.fechaFinal))
			return false;
		if (fechaInicial == null) {
			if (other.fechaInicial != null)
				return false;
		} else if (!fechaInicial.equals(other.fechaInicial))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
}
