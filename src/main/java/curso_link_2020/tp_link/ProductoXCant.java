package curso_link_2020.tp_link;

public class ProductoXCant {

	private Producto producto;
	private int cant;
	public ProductoXCant(Producto producto, int cant) {
		super();
		this.producto = producto;
		this.cant = cant;
	}
	
	public double precioFinal(){
		return producto.getPrecioPesos()*cant;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
	
}
