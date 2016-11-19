package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;

@Stateless
@LocalBean
public class BOProductoEJB extends EJBGenerico<Producto> implements InterfaceEJBRemote<Producto>{

	@Override
	public Class getClase() {
		return Producto.class;
	}

	@Override
	public void crear(Producto entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Producto con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Producto buscar(Object pk) {
		Producto p = dao.buscar(pk);
		if(p!=null){
			return p;
		}else{
			throw new ExcepcionFuncional("Aùn no existe un Producto con este codigo " + pk);
		}
	}

	@Override
	public void editar(Producto entidad) {
			dao.editar(entidad);
	}

	@Override
	public void eliminar(Producto entidad) {
			dao.borrar(entidad);
	}
	
	/**
	 * Lista los productos
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Producto> listarProductos(){
		return dao.ejecutarNamedQuery(Producto.LISTAR_PRODUCTOS);
	}


}
