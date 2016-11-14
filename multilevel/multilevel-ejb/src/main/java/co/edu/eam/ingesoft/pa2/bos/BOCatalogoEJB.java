package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;

@Stateless
@LocalBean
public class BOCatalogoEJB extends EJBGenerico<Catalogo> implements InterfaceEJBRemote<Catalogo>{

	@Override
	public Class getClase() {
		return Catalogo.class;
	}

	@Override
	public void crear(Catalogo entidad) {
		if (dao.buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un catalogo con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Catalogo buscar(Object pk) {
		Catalogo c = dao.buscar(pk);
		if(c!=null){
			return c;
		}else{
			throw new ExcepcionFuncional("Aùn no existe un catalogo con este codigo " + pk);
		}
	}

	@Override
	public void editar(Catalogo entidad) {
			dao.editar(entidad);
	}

	@Override
	public void eliminar(Catalogo entidad) {
			dao.borrar(entidad);
	}
	
	/**
	 * Lista los catalogos
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<Catalogo> listarCatalogos(){
		return dao.ejecutarNamedQuery(Catalogo.LISTAR_CATALOGOS);
	}


}
