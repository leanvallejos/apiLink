package curso_link_2020.tp_link;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Carrito {
	
	private Integer id; 
	private Collection<ProductoXCant> productos;
	
	
	
	public Carrito() {
		super();
	}

	public Carrito(Integer id, Collection<ProductoXCant> productos) {
		super();
		this.id = id;
		this.productos = productos;
	}

	public void agregarProducto(ProductoXCant producto) {
		this.productos.add(producto);
	}
	
	public void eliminarProducto(ProductoXCant producto){
		this.productos.remove(producto);
	}
	
	public Double total() {
		return productos.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
	}
	
	public void vaciar() {
		this.productos = new ArrayList<ProductoXCant>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<ProductoXCant> getProductos() {
		return productos;
	}

	public void setProductos(Collection<ProductoXCant> productos) {
		this.productos = productos;
	}
	
	
	
}
