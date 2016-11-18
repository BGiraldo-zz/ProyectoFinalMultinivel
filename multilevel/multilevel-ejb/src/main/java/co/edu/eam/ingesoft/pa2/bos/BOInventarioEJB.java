package co.edu.eam.ingesoft.pa2.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.dto.invDTO;
import co.edu.eam.ingesoft.pa2.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.implementacion.InterfaceEJBRemote;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Inventario;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Inventario;

@Stateless
@LocalBean
public class BOInventarioEJB extends EJBGenerico<Inventario> implements InterfaceEJBRemote<Inventario> {

	@Override
	public Class getClase() {
		return Inventario.class;
	}

	@Override
	public void crear(Inventario entidad) {
		if (buscar(entidad.getRepresentante().getId()) != null) {
			throw new ExcepcionFuncional("Ya existe un Inventario con este codigo " + entidad.getRepresentante().getId());
		} else {
			dao.crear(entidad);
		}

	}

	@Override
	public Inventario buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public void editar(Inventario entidad) {
		
		if (buscar(entidad.getId()) != null) {
			dao.editar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Inventario con este codigo " + entidad.getRepresentante().getId());
		}
	}

	@Override
	public void eliminar(Inventario entidad) {
		if (buscar(entidad.getRepresentante().getId()) != null) {
			dao.borrar(entidad);
		} else {
			throw new ExcepcionFuncional("Aùn no existe un Inventario con este codigo " + entidad.getRepresentante().getId());
		}
	}


	public List<Inventario> listarInventario(int ced) {
		//pass = MD5Util.code(pass);
		List<Inventario> lista = dao.ejecutarNamedQuery(Inventario.BUSCAR_INVENTARIO,ced);
		
		return lista;
		
	}
}
