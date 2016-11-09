package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable {

	@Id
	@Column(name = "PRODUCTO_ID", length = 12, nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CATEGORIA_ID", nullable=false)
	private CategoriaProducto categoria;
	
	@ManyToOne
	@JoinColumn(name="PROMOCION_ID", nullable=false)
	private Promocion promocion;

	@Column(name = "NOMBRE", length = 60, nullable = false)
	private String nombre;
	
	@Column(name="PRECIO_VENTA", length=7, nullable=false)
	private double precioVenta;
	
	@Column(name="PUNTOS", length=5, nullable=false)
	private int puntos;

	@Column(name = "CONTENIDO", length = 4, nullable = false)
	private int contenido;
	
	@Column(name="LUGAR_FABRICACION", length=60, nullable=true)
	private String lugarFabricacion;
	
	@Column(name="USO_SUGERIDO", length=60, nullable=true)
	private String usoSugerido;

	/**
	 * @param id
	 * @param categoria
	 * @param promocion
	 * @param nombre
	 * @param precioVenta
	 * @param puntos
	 * @param contenido
	 * @param lugarFabricacion
	 * @param usoSugerido
	 */
	public Producto(int id, CategoriaProducto categoria, Promocion promocion, String nombre, double precioVenta,
			int puntos, int contenido, String lugarFabricacion, String usoSugerido) {
		this.id = id;
		this.categoria = categoria;
		this.promocion = promocion;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.puntos = puntos;
		this.contenido = contenido;
		this.lugarFabricacion = lugarFabricacion;
		this.usoSugerido = usoSugerido;
	}

	/**
	 * 
	 */
	public Producto() {
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
	 * @return the categoria
	 */
	public CategoriaProducto getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the promocion
	 */
	public Promocion getPromocion() {
		return promocion;
	}

	/**
	 * @param promocion the promocion to set
	 */
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
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
	 * @return the precioVenta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * @return the contenido
	 */
	public int getContenido() {
		return contenido;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

	/**
	 * @return the lugarFabricacion
	 */
	public String getLugarFabricacion() {
		return lugarFabricacion;
	}

	/**
	 * @param lugarFabricacion the lugarFabricacion to set
	 */
	public void setLugarFabricacion(String lugarFabricacion) {
		this.lugarFabricacion = lugarFabricacion;
	}

	/**
	 * @return the usoSugerido
	 */
	public String getUsoSugerido() {
		return usoSugerido;
	}

	/**
	 * @param usoSugerido the usoSugerido to set
	 */
	public void setUsoSugerido(String usoSugerido) {
		this.usoSugerido = usoSugerido;
	}

	
}
