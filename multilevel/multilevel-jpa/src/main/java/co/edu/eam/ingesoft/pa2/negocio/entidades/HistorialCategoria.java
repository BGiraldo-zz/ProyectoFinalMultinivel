package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HISTORIAL_CATEGORIAS")
public class HistorialCategoria implements Serializable {

	@Id
	@Column(name="HISTORIAL_CATEGORIA_ID", length=12, nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="REPRESENTANTE_ID", nullable=false)
	private Representante representante;
	
	@ManyToOne
	@JoinColumn(name="CATEGORIA_REPRESENTANTES_ID", nullable=false)
	private CategoriaRepresentante categoriaRepresentante;
	
	@Column(name="FECHA", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fecha;
	
	@Column(name="ACOMULADO_PARCIAL", length=15, nullable=false)
	private int acomuladoParcial;

	/**
	 * @param id
	 * @param representante
	 * @param categoriaRepresentante
	 * @param fecha
	 * @param acomuladoParcial
	 */
	public HistorialCategoria(int id, Representante representante, CategoriaRepresentante categoriaRepresentante,
			Date fecha, int acomuladoParcial) {
		this.id = id;
		this.representante = representante;
		this.categoriaRepresentante = categoriaRepresentante;
		this.fecha = fecha;
		this.acomuladoParcial = acomuladoParcial;
	}

	/**
	 * 
	 */
	public HistorialCategoria() {
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
	 * @return the representante
	 */
	public Representante getRepresentante() {
		return representante;
	}

	/**
	 * @param representante the representante to set
	 */
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	/**
	 * @return the categoriaRepresentante
	 */
	public CategoriaRepresentante getCategoriaRepresentante() {
		return categoriaRepresentante;
	}

	/**
	 * @param categoriaRepresentante the categoriaRepresentante to set
	 */
	public void setCategoriaRepresentante(CategoriaRepresentante categoriaRepresentante) {
		this.categoriaRepresentante = categoriaRepresentante;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the acomuladoParcial
	 */
	public int getAcomuladoParcial() {
		return acomuladoParcial;
	}

	/**
	 * @param acomuladoParcial the acomuladoParcial to set
	 */
	public void setAcomuladoParcial(int acomuladoParcial) {
		this.acomuladoParcial = acomuladoParcial;
	}
	
	
	
	
}
