package curso_link_2020.tp_link;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@DiscriminatorValue("CUPON")
public class Cupon extends Promocion{
	
	@Column
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;
	

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;


	public Cupon() {
		super();
	}


	public Cupon(String nombre, Double porcentaje, boolean estaActivo, String codigo, Proveedor proveedor, Producto producto) {
		super(nombre, porcentaje, estaActivo);
		this.codigo = codigo;
		this.proveedor = proveedor;
		this.producto = producto;
	}
	


	

	@Override
	public boolean esValidoPara(OrdenDeCompra ordenDeCompra) {
		
		
		Collection<ProductoXCant> productos = ordenDeCompra.productosDeProovedor(this.proveedor);
		
		return productos.stream().anyMatch(unProducto -> unProducto.getProducto().equals(this.producto));

	}


	@Override
	public Double totalADescontar(OrdenDeCompra ordenDeCompra) {
		
		Collection<ProductoXCant> productos = ordenDeCompra.productosDeProovedor(this.proveedor);

		double totalProductos = productos.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
		
		return totalProductos;
	}

	
	
	public boolean tieneProveedor(String proveedor2) {
		return this.getProveedor().tieneNombre(proveedor2);
	}
	
	@Override
	public boolean tieneCodigo(String codigo) {
		return this.codigo.equals(codigo);
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	
	
	
	
}
