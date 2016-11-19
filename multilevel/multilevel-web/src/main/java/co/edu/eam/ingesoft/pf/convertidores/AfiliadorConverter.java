package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BORepresentanteEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Representante;

@Named
@FacesConverter(value = "afiliador", forClass = Representante.class)
public class AfiliadorConverter implements Converter {

	@EJB
	private BORepresentanteEJB representanteEJB;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Representante r = representanteEJB.buscar(Integer.valueOf(value));
			if (r != null)
				return r;
			return null;
		} catch (NumberFormatException nf) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Representante) {
			Representante r = (Representante) value;
			return String.valueOf(r.getId());
		}
		return null;
	}

}
