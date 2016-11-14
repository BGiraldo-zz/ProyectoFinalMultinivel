package co.edu.eam.ingesoft.pa2.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CATALOGO_PRODUCTOS")
@IdClass(CatalogoProductoPK.class)
@NamedQueries({@NamedQuery(name=CatalogoProducto.BUSCAR_PRODUCTO_CATALOGO,
query="SELECT cp FROM CatalogoProducto cp WHERE cp.catalogo.id = ?1 AND cp.producto.id = ?2")})
public class CatalogoProducto  implements Serializable{

	public static final String BUSCAR_PRODUCTO_CATALOGO = "CatalogoProducto.buscarProductoCatalogo";
	
	@Id
	@ManyToOne
	@JoinColumn(name="CATALOGO_ID", nullable=false)
	private Catalogo catalogo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID", nullable=false)
	private Producto producto;
	
	@Column(name="CANTIDAD_PRODUCTO", length=12, nullable=false)
	private int cantidadProducto;

	/**
	 * @param catalogo
	 * @param producto
	 * @param cantidadProducto
	 */
	public CatalogoProducto(Catalogo catalogo, Producto producto, int cantidadProducto) {
		this.catalogo = catalogo;
		this.producto = producto;
		this.cantidadProducto = cantidadProducto;
	}

	/**
	 * 
	 */
	public CatalogoProducto() {
	}

	/**
	 * @return the catalogo
	 */
	public Catalogo getCatalogo() {
		return catalogo;
	}

	/**
	 * @param catalogo the catalogo to set
	 */
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidadProducto
	 */
	public int getCantidadProducto() {
		return cantidadProducto;
	}

	/**
	 * @param cantidadProducto the cantidadProducto to set
	 */
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	

}
