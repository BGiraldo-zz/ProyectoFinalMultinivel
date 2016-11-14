package co.edu.eam.ingesoft.pf.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.bos.BOCategoriaProductoEJB;
import co.edu.eam.ingesoft.pa2.bos.BOProductoEJB;
import co.edu.eam.ingesoft.pa2.bos.BOPromocionEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaProducto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;
import co.edu.eam.ingesoft.pf.interceptores.ExceptionLogger;

@Named("ControladorManejoProducto")
@ViewScoped
@ExceptionLogger
public class ControladorManejoProducto implements Serializable {

	private Producto producto;

	private List<CategoriaProducto> categorias;

	private List<Promocion> promociones;

	@EJB
	private BOCategoriaProductoEJB categoriaEJB;

	@EJB
	private BOPromocionEJB promocionEJB;
	
	@EJB
	private BOProductoEJB productoEJB;

	@PostConstruct
	public void inicializar() {

		producto = new Producto();
		categorias = categoriaEJB.listarCategoriasProducto();
		promociones = promocionEJB.listarPromociones();
		

	}

	/**
	 * Registra Un producto
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void registrar() {
		productoEJB.crear(producto);
		Messages.addGlobalInfo("Producto Registrado Correctamente");
		inicializar();
	}

	/**
	 * Busca un producto
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void buscar() {

		Producto p = productoEJB.buscar(producto.getId());
		producto.setCategoria(p.getCategoria());
		producto.setContenido(p.getContenido());
		producto.setLugarFabricacion(p.getLugarFabricacion());
		producto.setNombre(p.getNombre());
		producto.setPrecioVenta(p.getPrecioVenta());
		producto.setPromocion(p.getPromocion());
		producto.setPuntos(p.getPuntos());
		producto.setUsoSugerido(p.getUsoSugerido());
		
	}

	/**
	 * Edita un producto
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void editar() {

		Producto p = productoEJB.buscar(producto.getId());
		p.setCategoria(producto.getCategoria());
		p.setContenido(producto.getContenido());
		p.setLugarFabricacion(producto.getLugarFabricacion());
		p.setNombre(producto.getNombre());
		p.setPrecioVenta(producto.getPrecioVenta());
		p.setPromocion(producto.getPromocion());
		p.setPuntos(producto.getPuntos());
		p.setUsoSugerido(producto.getUsoSugerido());
		productoEJB.editar(p);
		Messages.addGlobalInfo("Producto Editado Correctamente");
		
	}

	/**
	 * Elimina un producto
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public void remover() {
		Producto p = productoEJB.buscar(producto.getId());
		productoEJB.eliminar(p);
		Messages.addGlobalInfo("Producto Eliminado Correctamente");
		inicializar();
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto
	 *            the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the categorias
	 */
	public List<CategoriaProducto> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias
	 *            the categorias to set
	 */
	public void setCategorias(List<CategoriaProducto> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the promociones
	 */
	public List<Promocion> getPromociones() {
		return promociones;
	}

	/**
	 * @param promociones
	 *            the promociones to set
	 */
	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	/**
	 * @return the categoriaEJB
	 */
	public BOCategoriaProductoEJB getCategoriaEJB() {
		return categoriaEJB;
	}

	/**
	 * @param categoriaEJB the categoriaEJB to set
	 */
	public void setCategoriaEJB(BOCategoriaProductoEJB categoriaEJB) {
		this.categoriaEJB = categoriaEJB;
	}

	/**
	 * @return the promocionEJB
	 */
	public BOPromocionEJB getPromocionEJB() {
		return promocionEJB;
	}

	/**
	 * @param promocionEJB the promocionEJB to set
	 */
	public void setPromocionEJB(BOPromocionEJB promocionEJB) {
		this.promocionEJB = promocionEJB;
	}

	/**
	 * @return the productoEJB
	 */
	public BOProductoEJB getProductoEJB() {
		return productoEJB;
	}

	/**
	 * @param productoEJB the productoEJB to set
	 */
	public void setProductoEJB(BOProductoEJB productoEJB) {
		this.productoEJB = productoEJB;
	}
	
	

}
