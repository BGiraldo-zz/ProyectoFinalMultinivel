package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.EstadoRepresentanteENUM;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoDocumentoENUM;
import co.edu.eam.ingesoft.pa2.negocio.enumeraciones.TipoPersonaENUM;

@Entity
@Table(name="REPRESENTANTES")
@NamedQueries({@NamedQuery(name=Representante.LISTAR_REPRESENTANTES,
query="SELECT r FROM Representante r" )})
public class Representante extends Persona implements Serializable {
	
	public static final String LISTAR_REPRESENTANTES = "Representante.listarRepresentantes";
	
	@ManyToOne
	@JoinColumn(name="CATEGORIA_REPRESENTANTES_ID", nullable=false)
	private CategoriaRepresentante categoria;
	
	@Column(name="SUELDO_ACTUAL", length=12, nullable=false)
	private double sueldoActual;
	
	
	@Column(name="ACOMULADO_TOTAL", length=15, nullable=false)
	private int acomuladoTotal;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="ESTADO", length=15, nullable=false)
	private EstadoRepresentanteENUM estado;
	
	@ManyToOne
	@JoinColumn(name = "AFILIADOR_ID", nullable = true, referencedColumnName="PERSONA_ID")
	private Representante afiliador;

	@Column(name="FECHA_AFILIACION", nullable = false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaAfiliacion;

	/**
	 * @param id
	 * @param email
	 * @param login
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param genero
	 * @param telefono
	 * @param tipoUsuario
	 * @param tipoDocumento
	 * @param categoria
	 * @param sueldoActual
	 * @param acomuladoTotal
	 * @param estado
	 * @param afiliador
	 * @param fechaAfiliacion
	 */
	public Representante(int id, String email, Login login, String nombre, String apellido, Date fechaNacimiento,
			char genero, String telefono, TipoPersonaENUM tipoUsuario, TipoDocumentoENUM tipoDocumento,
			CategoriaRepresentante categoria, double sueldoActual, int acomuladoTotal, EstadoRepresentanteENUM estado,
			Representante afiliador, Date fechaAfiliacion) {
		super(id, email, login, nombre, apellido, fechaNacimiento, genero, telefono, tipoUsuario, tipoDocumento);
		this.categoria = categoria;
		this.sueldoActual = sueldoActual;
		this.acomuladoTotal = acomuladoTotal;
		this.estado = estado;
		this.afiliador = afiliador;
		this.fechaAfiliacion = fechaAfiliacion;
	}

	/**
	 * @param id
	 * @param email
	 * @param login
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param genero
	 * @param telefono
	 * @param tipoUsuario
	 * @param tipoDocumento
	 */
	public Representante(int id, String email, Login login, String nombre, String apellido, Date fechaNacimiento,
			char genero, String telefono, TipoPersonaENUM tipoUsuario, TipoDocumentoENUM tipoDocumento) {
		super(id, email, login, nombre, apellido, fechaNacimiento, genero, telefono, tipoUsuario, tipoDocumento);
	}


	public Representante(){
		
	}

	/**
	 * @return the categoria
	 */
	public CategoriaRepresentante getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaRepresentante categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the sueldoActual
	 */
	public double getSueldoActual() {
		return sueldoActual;
	}

	/**
	 * @param sueldoActual the sueldoActual to set
	 */
	public void setSueldoActual(double sueldoActual) {
		this.sueldoActual = sueldoActual;
	}

	/**
	 * @return the acomuladoTotal
	 */
	public int getAcomuladoTotal() {
		return acomuladoTotal;
	}

	/**
	 * @param acomuladoTotal the acomuladoTotal to set
	 */
	public void setAcomuladoTotal(int acomuladoTotal) {
		this.acomuladoTotal = acomuladoTotal;
	}

	/**
	 * @return the estado
	 */
	public EstadoRepresentanteENUM getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoRepresentanteENUM estado) {
		this.estado = estado;
	}

	/**
	 * @return the afiliador
	 */
	public Representante getAfiliador() {
		return afiliador;
	}

	/**
	 * @param afiliador the afiliador to set
	 */
	public void setAfiliador(Representante afiliador) {
		this.afiliador = afiliador;
	}

	/**
	 * @return the fechaAfiliacion
	 */
	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	/**
	 * @param fechaAfiliacion the fechaAfiliacion to set
	 */
	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + acomuladoTotal;
		result = prime * result + ((afiliador == null) ? 0 : afiliador.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaAfiliacion == null) ? 0 : fechaAfiliacion.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sueldoActual);
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Representante other = (Representante) obj;
		if (acomuladoTotal != other.acomuladoTotal)
			return false;
		if (afiliador == null) {
			if (other.afiliador != null)
				return false;
		} else if (!afiliador.equals(other.afiliador))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (estado != other.estado)
			return false;
		if (fechaAfiliacion == null) {
			if (other.fechaAfiliacion != null)
				return false;
		} else if (!fechaAfiliacion.equals(other.fechaAfiliacion))
			return false;
		if (Double.doubleToLongBits(sueldoActual) != Double.doubleToLongBits(other.sueldoActual))
			return false;
		return true;
	}

	
	

}
