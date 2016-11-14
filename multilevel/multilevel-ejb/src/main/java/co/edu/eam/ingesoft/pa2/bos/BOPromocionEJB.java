package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;

@Stateless
@LocalBean
public class BOPromocionEJB extends EJBGenerico<Promocion> implements InterfaceEJBRemote<Promocion>{

	@Override
	public Class getClase() {
		return Promocion.class;
	}

	@Override
	public void crear(Promocion entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Promocion con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Promocion buscar(Object pk) {
		Promocion p = dao.buscar(pk);
		if(p != null){
			return p;
		}else{
			throw new ExcepcionFuncional("Aùn no existe una promoción con este codigo " + pk);
		}
	}

	@Override
	public void editar(Promocion entidad) {
			dao.editar(entidad);
	}

	@Override
	public void eliminar(Promocion entidad) {
			dao.borrar(entidad);
	}
	
	/**
	 * lista las promociones para los productos
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Promocion> listarPromociones(){
		return dao.ejecutarNamedQuery(Promocion.LISTAR_PROMOCIONES);
	}
	
	

}
