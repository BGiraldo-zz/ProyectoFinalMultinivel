package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOCategoriaRepresentanteEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaRepresentante;

@Named
@FacesConverter(value="categoria", forClass=CategoriaRepresentante.class)
public class CategoriaRepresentanteConverter implements Converter {

	@EJB
	private BOCategoriaRepresentanteEJB categoriaEJB;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		
		try{
		CategoriaRepresentante c = categoriaEJB.buscar(Integer.valueOf(value));
		if(c!=null)
			return c;
		
		return null;
		} catch (NumberFormatException nf) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof CategoriaRepresentante){
			CategoriaRepresentante c = (CategoriaRepresentante)value;
			return String.valueOf(c.getId());
		}
		return null;
	}

}
