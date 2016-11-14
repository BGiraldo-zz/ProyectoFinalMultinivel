package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOPremioEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Premio;

@Named
@FacesConverter(value="premioConverter", forClass=Premio.class)
public class PremioConverter implements Converter{

	@EJB
	private BOPremioEJB premioEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try{
			
			Premio p = premioEJB.buscar(Integer.valueOf(value));
			return p;
			
		}catch(NumberFormatException nf){
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value instanceof Premio){
			Premio p = (Premio)value;
			return String.valueOf(p.getId());
		}
		
		return null;
	}

	
	
}
