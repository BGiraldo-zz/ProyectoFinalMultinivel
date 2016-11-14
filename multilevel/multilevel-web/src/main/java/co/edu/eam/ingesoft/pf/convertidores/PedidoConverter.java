package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOPedidoEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Pedido;

@Named
@FacesConverter(value="pedidoConverter", forClass=PedidoConverter.class)
public class PedidoConverter implements Converter {

	@EJB
	private BOPedidoEJB pedidoEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		try{
			Pedido p = pedidoEJB.buscar(Integer.valueOf(value));
			return p;
			
		}catch(NumberFormatException nf){
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Pedido){
			Pedido p = (Pedido) value;
			return String.valueOf(p.getId());
		}
		return null;
	}

}
