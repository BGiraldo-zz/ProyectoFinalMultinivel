package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;

@Stateless
@LocalBean
public class BOCatalogoProductoEJB extends EJBGenerico<CatalogoProducto>
		implements InterfaceEJBRemote<CatalogoProducto> {

	@EJB
	private BOCatalogoEJB catalogoEJB;

	@EJB
	private BOProductoEJB productoEJB;

	@Override
	public Class getClase() {
		return CatalogoProducto.class;
	}

	@Override
	public void crear(CatalogoProducto entidad) {
		CatalogoProducto cp = null;
		CatalogoProducto catPro = new CatalogoProducto();
		try {
			cp = dao.ejecutarQuery(CatalogoProducto.BUSCAR_PRODUCTO_CATALOGO, entidad.getCatalogo().getId(),
					entidad.getProducto().getId());
		} catch (Exception e) {
			cp = null;
		}

		if (cp == null) {
			Catalogo c = catalogoEJB.buscar(entidad.getCatalogo().getId());
			Producto p = productoEJB.buscar(entidad.getProducto().getId());
			catPro.setCantidadProducto(entidad.getCantidadProducto());
			catPro.setCatalogo(c);
			catPro.setProducto(p);
			dao.crear(catPro);
		} else {
			Catalogo c = catalogoEJB.buscar(entidad.getCatalogo().getId());
			Producto p = productoEJB.buscar(entidad.getProducto().getId());
			catPro.setCantidadProducto(entidad.getCantidadProducto());
			catPro.setCatalogo(c);
			catPro.setProducto(p);
			dao.editar(catPro);
		}

	}

	/**
	 * busca un producto en un catalogo
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public CatalogoProducto buscarCatalogoProducto(int idCat, int idPro) {
		CatalogoProducto cp = null;
		try {
			cp = dao.ejecutarQuery(CatalogoProducto.BUSCAR_PRODUCTO_CATALOGO, idCat, idPro);
		} catch (Exception e) {
			cp = null;
		}
		if (cp != null) {
			return cp;
		} else {
			throw new ExcepcionFuncional("No se ha encontado este producto en dicho catalogo");
		}
	}

	@Override
	public CatalogoProducto buscar(Object pk) {
		return null;
	}

	@Override
	public void editar(CatalogoProducto e) {
		CatalogoProducto cp = buscarCatalogoProducto(e.getCatalogo().getId(), e.getProducto().getId());
		cp.setCantidadProducto(e.getCantidadProducto());
		dao.editar(cp);
	}

	@Override
	public void eliminar(CatalogoProducto e) {
		CatalogoProducto cp = buscarCatalogoProducto(e.getCatalogo().getId(), e.getProducto().getId());
		dao.borrar(cp);
	}

}
