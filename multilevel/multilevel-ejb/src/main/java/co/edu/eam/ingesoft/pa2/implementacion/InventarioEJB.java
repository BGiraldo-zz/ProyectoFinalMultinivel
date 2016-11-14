package co.edu.eam.ingesoft.pa2.implementacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.dto.invDTO;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Inventario;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Login;
@LocalBean
@Stateless
public class InventarioEJB extends EJBGenerico<Inventario>{

	@Override
	public Class getClase() {
		return Inventario.class;
	}
	
	
	public List<invDTO> listarInventario(int ced) {
		//pass = MD5Util.code(pass);
		List<invDTO> lista = dao.ejecutarNamedQuery(Inventario.BUSCAR_INVENTARIO,ced);
		
		if (!lista.isEmpty()) {
			return lista;
		} else {  
			return null;
		}
		
	}
}
