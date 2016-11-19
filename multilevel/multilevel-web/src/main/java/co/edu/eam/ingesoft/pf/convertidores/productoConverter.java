package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOProductoEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;

@Named
@FacesConverter(value="productoConverter", forClass=Producto.class)
public class productoConverter implements Converter{

	@EJB
	private BOProductoEJB productoEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try{
			Producto p = productoEJB.buscar(Integer.valueOf(value));
			return p;
		}catch(NumberFormatException nf){
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Producto){
			Producto p = (Producto)value;
			return String.valueOf(p.getId());
		}
		return null;
	}

}
