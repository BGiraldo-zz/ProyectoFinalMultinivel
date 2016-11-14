package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOCiudadEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Ciudad;

@Named
@FacesConverter(value="ciudad", forClass=Ciudad.class)
public class CiudadConverter implements Converter{

	@EJB
	private BOCiudadEJB ciudadEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		try{
		Ciudad c = ciudadEJB.buscar(Integer.valueOf(value));
		if(c!=null)
			return c;
		
		return null;
		} catch (NumberFormatException nf) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
	
		if(value instanceof Ciudad){
			Ciudad c = (Ciudad) value;
		    return String.valueOf(c.getId());
		}

		return null;
	}

}
