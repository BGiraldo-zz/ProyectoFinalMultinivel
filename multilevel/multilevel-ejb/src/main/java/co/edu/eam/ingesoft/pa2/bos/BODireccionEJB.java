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
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una Direccion con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}
	}

	@Override
	public Direccion buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Direccion entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Direccion entidad) {
		// TODO Auto-generated method stub
		
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
