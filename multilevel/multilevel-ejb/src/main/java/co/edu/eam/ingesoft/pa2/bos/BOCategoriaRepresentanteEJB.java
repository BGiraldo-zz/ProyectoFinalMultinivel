package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaRepresentante;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaRepresentante;

@Stateless
@LocalBean
public class BOCategoriaRepresentanteEJB  extends EJBGenerico<CategoriaRepresentante> implements InterfaceEJBRemote<CategoriaRepresentante>{

	@Override
	public Class getClase() {
		return CategoriaRepresentante.class;
	}

	@Override
	public void crear(CategoriaRepresentante entidad) {
		if (buscar(entidad.getId()) != null) {
			throw new ExcepcionFuncional("Ya existe una categoria del representante con este codigo " + entidad.getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public CategoriaRepresentante buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(CategoriaRepresentante entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Categoria del Representante con este codigo " + entidad.getId());
		}
	}

	@Override
	public void eliminar(CategoriaRepresentante entidad) {
		if (buscar(entidad.getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe una Categoria del Representante con este codigo " + entidad.getId());
		}
	}

	/**
	 * Lista las categorias representante disponibles en la BD
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public List<CategoriaRepresentante> listarCategorias(){
		return dao.ejecutarNamedQuery(CategoriaRepresentante.LISTAR_CATEGORIA);
	}
	
}
