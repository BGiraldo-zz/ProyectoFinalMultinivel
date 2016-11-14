package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaProducto;

@Stateless
@LocalBean
public class BOCategoriaProductoEJB extends EJBGenerico<CategoriaProducto>
		implements InterfaceEJBRemote<CategoriaProducto> {

	@Override
	public Class getClase() {
		return CategoriaProducto.class;
	}

	@Override
	public void crear(CategoriaProducto entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un categoria de producto " + "con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public CategoriaProducto buscar(Object pk) {
		CategoriaProducto cp = dao.buscar(pk);
		if (cp != null) {
			return cp;
		} else {
			throw new ExcepcionFuncional("Aùn no existe un categoria del producto con este codigo " + pk);

		}
	}

	@Override
	public void editar(CategoriaProducto entidad) {
		dao.editar(entidad);
	}

	@Override
	public void eliminar(CategoriaProducto entidad) {
		dao.borrar(entidad);
	}
	
	/**
	 * Lista las categorias de los productos
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<CategoriaProducto> listarCategoriasProducto(){
		return dao.ejecutarNamedQuery(CategoriaProducto.LISTAR_CATEGORIAS_PRODUCTOS);
	}

}
