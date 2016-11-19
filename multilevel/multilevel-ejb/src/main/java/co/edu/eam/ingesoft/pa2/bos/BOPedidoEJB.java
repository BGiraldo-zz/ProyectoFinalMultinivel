package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Pedido;

@Stateless
@LocalBean
public class BOPedidoEJB extends EJBGenerico<Pedido> implements InterfaceEJBRemote<Pedido>{

	@Override
	public void crear(Pedido entidad) {
		if(dao.buscar(entidad.getId())!=null){
			throw new ExcepcionFuncional("Ya Existe pedido con codigo " + entidad.getId());
		}else{
			dao.crear(entidad);
		}
	}

	@Override
	public Pedido buscar(Object pk) {
		Pedido p = dao.buscar(pk);
		if(p!=null){
			return p;
		}else{
			throw new ExcepcionFuncional("No se ha encontrado pedido con codigo " + pk);
		}
	}

	@Override
	public void editar(Pedido entidad) {
		dao.editar(entidad);
	}

	@Override
	public void eliminar(Pedido entidad) {
		dao.borrar(entidad);
	}

	@Override
	public Class getClase() {
		return Pedido.class;
	}
	
	/**
	 * Lista los pedidos 
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Pedido> listarPedidos(){
		return dao.ejecutarNamedQuery(Pedido.LISTAR_PEDIDOS);
	}
	
	/**
	 * Lista todos los pedido pendientes a aprobacion
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Pedido> listarPedidosPendientes(){
		List<Pedido>  pedidos = dao.ejecutarNamedQuery(Pedido.LISTAR_PEDIDOS_PENDIENTES, 'P' );
		return pedidos;
	}

}
