package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AFILIADOS")
@IdClass(AfiliadoPK.class)
public class Afiliado implements Serializable{

	@Id
	@Column(name="AFILIADO_ID", nullable = false, length=12)
	private int id;
	
	@Id
	@OneToOne
	@JoinColumn(name = "REPRESENTANTE_ID", nullable = false)
	private Representante representante;

	@Column(name="FECHA_AFILIACION", nullable = false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaAfiliacion;

	/**
	 * @param id
	 * @param representante
	 * @param fechaAfiliacion
	 */
	public Afiliado(int id, Representante representante, Date fechaAfiliacion) {
		this.id = id;
		this.representante = representante;
		this.fechaAfiliacion = fechaAfiliacion;
	}
	
	

	/**
	 * 
	 */
	public Afiliado() {
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}
	
	
}
