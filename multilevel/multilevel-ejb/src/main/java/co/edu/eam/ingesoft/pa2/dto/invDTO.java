package co.edu.eam.ingesoft.pa2.dto;


public class invDTO {
	
	private int representantes;

	
	private String productos;
	
	private double cantidads;
	
	private double precioBases;

	
	public invDTO() {
		
	}


	public invDTO(int representantes, String productos, double cantidads, double precioBases) {
		super();
		this.representantes = representantes;
		this.productos = productos;
		this.cantidads = cantidads;
		this.precioBases = precioBases;
	}


	public int getRepresentantes() {
		return representantes;
	}


	public void setRepresentantes(int representantes) {
		this.representantes = representantes;
	}


	public String getProductos() {
		return productos;
	}


	public void setProductos(String productos) {
		this.productos = productos;
	}


	public double getCantidads() {
		return cantidads;
	}


	public void setCantidads(double cantidads) {
		this.cantidads = cantidads;
	}


	public double getPrecioBases() {
		return precioBases;
	}


	public void setPrecioBases(double precioBases) {
		this.precioBases = precioBases;
	}
	
}
