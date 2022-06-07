package domain;

import java.time.LocalDate;

public class Cotizacion {

	private String fecha;
	private Double compra;
	private Double venta;
	
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getCompra() {
		return compra;
	}
	public void setCompra(Double compra) {
		this.compra = compra;
	}
	public Double getVenta() {
		return venta;
	}
	public void setVenta(Double venta) {
		this.venta = venta;
	}
	public Cotizacion(String fecha, Double compra, Double venta) {
		super();
		this.fecha = fecha;
		this.compra = compra;
		this.venta = venta;
	}
	public Cotizacion() {
		super();
	}
	
	
	
}
