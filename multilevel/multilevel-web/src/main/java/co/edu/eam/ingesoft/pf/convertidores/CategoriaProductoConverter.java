package co.edu.eam.ingesoft.pf.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.bos.BOCategoriaProductoEJB;
import co.edu.eam.ingesoft.pa2.negocio.entidades.CategoriaProducto;

@Named
@FacesConverter(value = "categoriaProducto", forClass = CategoriaProducto.class)
public class CategoriaProductoConverter implements Converter {

	@EJB
	private BOCategoriaProductoEJB categoriaProductoEJB;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			CategoriaProducto cp = categoriaProductoEJB.buscar(Integer.valueOf(value));
			if (cp != null) {
				return cp;
			}
			return null;
		} catch (NumberFormatException nf) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof CategoriaProducto) {
			CategoriaProducto cp = (CategoriaProducto) value;
			return String.valueOf(cp.getId());
		}
		return null;
	}

}
