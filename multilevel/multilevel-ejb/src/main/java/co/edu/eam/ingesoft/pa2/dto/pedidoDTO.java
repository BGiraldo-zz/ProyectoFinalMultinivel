package co.edu.eam.ingesoft.pa2.dto;

import java.util.List;

import co.edu.eam.ingesoft.pa2.negocio.entidades.Producto;

public class pedidoDTO {
	
	public static class ItemDTO{
		private Producto producto;
		private int cantidad;
		private double precio;
		public Producto getProducto() {
			return producto;
		}
		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}

	}
	
	private List<ItemDTO> pedido;

	public List<ItemDTO> getPedido() {
		return pedido;
	}

	public void setPedido(List<ItemDTO> pedido) {
		this.pedido = pedido;
	}

	
	
}
