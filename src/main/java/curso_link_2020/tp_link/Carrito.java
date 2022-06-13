package curso_link_2020.tp_link;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<ProductoXCant> productosXCant;
	

	public Carrito() {
		super();
		this.productosXCant = new ArrayList<ProductoXCant>();
		
	}




	public Carrito(Collection<ProductoXCant> productosXCant) {
		super();
		this.productosXCant = productosXCant;
	}



	public void agregarProducto(ProductoXCant producto) {
		this.productosXCant.add(producto);
	}
	
	public void eliminarProducto(ProductoXCant producto){
		this.productosXCant.remove(producto);
	}

	public Double total() {
		return productosXCant.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
	}
	
	public void vaciar() {
		this.productosXCant = new ArrayList<ProductoXCant>();
	}


	public Collection<ProductoXCant> getProductos() {
		return productosXCant;
	}

	public void setProductos(Collection<ProductoXCant> productos) {
		this.productosXCant = productos;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Collection<ProductoXCant> getProductosXCant() {
		return productosXCant;
	}



	public void setProductosXCant(Collection<ProductoXCant> productosXCant) {
		this.productosXCant = productosXCant;
	}
	
	
	
}
