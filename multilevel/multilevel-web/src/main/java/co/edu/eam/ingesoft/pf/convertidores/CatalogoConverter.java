package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOCatalogoEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Catalogo;

@Named
@FacesConverter(value="catalogoConverter", forClass=Catalogo.class)
public class CatalogoConverter implements Converter{

	@EJB
	private BOCatalogoEJB catalogoEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		try{
			
			Catalogo c = catalogoEJB.buscar(Integer.valueOf(value));
			return c;
			
		} catch (NumberFormatException nf) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Catalogo){
			Catalogo c = (Catalogo)value;
			return String.valueOf(c.getId());
		}
		return null;
	}

}
