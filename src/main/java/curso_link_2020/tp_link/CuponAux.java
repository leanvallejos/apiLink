package curso_link_2020.tp_link;

public class CuponAux {

	private String nombre;
	private boolean activo;
	private String codigo;
	private String nombreProveedor;
	private String nombreProducto;
	private Double porcentaje;
	
	
	
	public CuponAux() {} 

	


	public CuponAux(String nombre, Double porcentaje, boolean estaActivo,String codigo, String nombreProveedor, String nombreProducto) {
		super();
		this.nombre = nombre;
		this.activo = estaActivo;
		this.codigo = codigo;
		this.nombreProveedor = nombreProveedor;
		this.nombreProducto = nombreProducto;
		this.porcentaje = porcentaje;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombreCupon) {
		this.nombre = nombreCupon;
	}




	public String getNombreProveedor() {
		return nombreProveedor;
	}


	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}


	public Double getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}




	public String getNombreProducto() {
		return nombreProducto;
	}




	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
