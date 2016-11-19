package co.edu.eam.ingesoft.pa2.dto;

import java.util.List;

public class pedidolDTO {
private List<pedidoDTO> listaa;

public pedidolDTO(List<pedidoDTO> lista) {
	super();
	this.listaa = lista;
}

public pedidolDTO() {
	
}

public List<pedidoDTO> getProd() {
	return listaa;
}

public void setProd(List<pedidoDTO> prod) {
	this.listaa = prod;
}

}
