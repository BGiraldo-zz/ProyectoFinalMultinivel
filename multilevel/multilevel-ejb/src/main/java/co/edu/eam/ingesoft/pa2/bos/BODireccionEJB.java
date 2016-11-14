package co.edu.eam.ingesoft.pa2.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Direccion;

@Stateless
@LocalBean
public class BODireccionEJB extends EJBGenerico<Direccion> implements InterfaceEJBRemote<Direccion>{

	@Override
	public void crear(Direccion entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Direccion con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Direccion buscar(Object pk) {
		Direccion d =  dao.buscar(pk);
		if(d!=null){
			return d;
		}else{
			throw new ExcepcionFuncional("No existe una Direccion con este codigo " + pk);
		}
	}

	@Override
	public void editar(Direccion entidad) {
		dao.editar(entidad);
	}

	@Override
	public void eliminar(Direccion entidad) {
		dao.borrar(entidad);
	}

	@Override
	public Class getClase() {
		return Direccion.class;
	}
	
	/**
	 * Trae la cantidad de direcciones registradas en la BD
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public int cantidadDirecciones(){
		long l = dao.ejecutarQuery(Direccion.CANTIDAD_DIRECCIONES);
		int v = (int)l;
		return v;
	}
	
	

}
