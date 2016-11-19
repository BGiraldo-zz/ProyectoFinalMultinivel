package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOPromocionEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.Promocion;

@Named
@FacesConverter(value = "promocionConverter", forClass = Promocion.class)
public class PromocionConverter implements Converter {

	@EJB
	private BOPromocionEJB promocionEJB;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		try {
			Promocion p = promocionEJB.buscar(Integer.valueOf(value));
			if (p != null) {
				return p;
			}
			return null;
		} catch (NumberFormatException nf) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Promocion) {
			Promocion p = (Promocion) value;
			return String.valueOf(p.getId());
		}
		return null;
	}

}
