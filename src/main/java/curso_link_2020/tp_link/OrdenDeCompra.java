package curso_link_2020.tp_link;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import domain.NoHayMedioDePagoException;


public class OrdenDeCompra {
	
	private Integer id;
	private LocalDate fecha;
	private Collection<Promocion> promociones;
	private Collection<ProductoXCant> productos;
	private Usuario usuario;
	private MedioPago medioPago;
	

	public OrdenDeCompra(Integer id, LocalDate fecha, Collection<ProductoXCant> productos,
			Usuario cliente, MedioPago medioPago) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.productos = productos;
		this.usuario = cliente;
		this.medioPago = medioPago;
		this.promociones = new ArrayList<Promocion>();
	}


	public void ejecutar() throws Exception {
		
		usuario.pagar(this.total(), this.medioPago);
		usuario.agregarOrdenCompra(this);
	}
	


	public double total() throws Exception {
		
		double totalProductos = totalSinDescuento();
		double descuentosPromociones = totalADescontar();

		return  max(totalProductos - descuentosPromociones, 0);
	}

	public double totalADescontar() throws Exception {
		if(this.medioPago == null) {
			throw new NoHayMedioDePagoException("Se debe agregar un medio de pago a la orden de compra");
		}
		return promociones.stream().mapToDouble(promocion -> promocion.descuento(this)).sum();
	}

	public double totalSinDescuento() {
		return productos.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
	}
	
	public  List<ProductoXCant> productosDeProovedor(Proveedor proveedor) {
		 List<ProductoXCant> productos = this.productos.stream().filter(producto -> producto.getProducto().tieneProveedor(proveedor)).collect(Collectors.toList());
		 if(productos.isEmpty()) {
			 return null;
		 }
		 return productos;
	}
	
	public void agregarPromocion(Promocion promo) throws Exception{
		
			this.promociones.add(promo);
		
	}
	
	public void agregarPromociones(Collection<Promocion> promociones) {
		this.promociones.addAll(promociones);
	}

	private double max(double d, int i) {
		if(d > i) {
			return d;
		}
		return i;
	}

	public Collection<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Collection<Promocion> promociones) {
		this.promociones = promociones;
	}


	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}


	public boolean clienteTieneMembresia() {
		return this.usuario.isTieneMembresia();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	

	public Collection<ProductoXCant> getProductos() {
		return productos;
	}


	public void setProductos(Collection<ProductoXCant> productos) {
		this.productos = productos;
	}


	@Override
	public boolean equals(Object obj) {
		OrdenDeCompra otraOrden = (OrdenDeCompra) obj;
		
		return this.id.equals(otraOrden.getId());
	}


	
	
	
	
}
