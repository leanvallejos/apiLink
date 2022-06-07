package domain;

import javax.validation.constraints.NotBlank;

public class ProductoAux {

	private String nombre;
	
	private String descripcion;
	
	private Double precioDolar;

	private String proveedor;
	
	

	public ProductoAux() {
		super();
	}

	public ProductoAux(String nombre, String descripcion, Double precioDolar, String proveedor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioDolar = precioDolar;
		this.proveedor = proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecioDolar() {
		return precioDolar;
	}

	public void setPrecioDolar(Double precioDolar) {
		this.precioDolar = precioDolar;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
