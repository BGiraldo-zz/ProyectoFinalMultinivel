package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Premio;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Premio;

@Stateless
@LocalBean
public class BOPremioEJB extends EJBGenerico<Premio> implements InterfaceEJBRemote<Premio>{

	@Override
	public Class getClase() {
		return Premio.class;
	}

	@Override
	public void crear(Premio entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Premio con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Premio buscar(Object pk) {
		Premio p = dao.buscar(pk);
		if(p!=null){
			return p;
		}else{
			throw new ExcepcionFuncional("Aùn no existe un Premio con este codigo " + pk);

		}
	}

	@Override
	public void editar(Premio entidad) {
			dao.editar(entidad);
	}

	@Override
	public void eliminar(Premio entidad) {
			dao.borrar(entidad);
	}

	/**
	 * Lista los premios
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Premio> listarPremios(){
		return dao.ejecutarNamedQuery(Premio.LISTAR_PREMIOS);
	}

}
