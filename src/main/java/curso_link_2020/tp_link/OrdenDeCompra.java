package curso_link_2020.tp_link;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import domain.NoHayMedioDePagoException;

@Entity
public class OrdenDeCompra {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private LocalDate fecha;
	
	@ManyToMany
	private Collection<Promocion> promociones;
	
	@OneToMany
	private Collection<ProductoXCant> productoXCant;
	
	@ManyToOne
	private Usuario usuario;
	
	@Column
	private MedioPago medioPago;
	
	@Column
	private Double totalSinDescuento;
	
	@Column
	private Double totalADescontar;
	
	@Column
	private Double total;

	
	
	public OrdenDeCompra() {
		super();
	}


	public OrdenDeCompra(LocalDate fecha, Collection<ProductoXCant> productos,
			Usuario cliente, MedioPago medioPago) {
		super();
		this.fecha = fecha;
		this.productoXCant = productos;
		this.usuario = cliente;
		this.medioPago = medioPago;
		this.promociones = new ArrayList<Promocion>();
	}
	
	


	public OrdenDeCompra(LocalDate fecha, Collection<Promocion> promociones, Collection<ProductoXCant> productoXCant,
			Usuario usuario, MedioPago medioPago, Double totalSinDescuento, Double totalADescontar, Double total) {
		super();
		this.fecha = fecha;
		this.promociones = promociones;
		this.productoXCant = productoXCant;
		this.usuario = usuario;
		this.medioPago = medioPago;
		this.totalSinDescuento = totalSinDescuento;
		this.totalADescontar = totalADescontar;
		this.total = total;
	}


	public void ejecutar() throws Exception {
		
		usuario.pagar(this.total(), this.medioPago);
		usuario.agregarOrdenCompra(this);
	}
	


	public double total() throws Exception {
		
		
		return  max(totalSinDescuento - totalADescontar, 0);
	}

	public double totalADescontar() throws Exception {
		if(this.medioPago == null) {
			throw new NoHayMedioDePagoException("Se debe agregar un medio de pago a la orden de compra");
		}
		return promociones.stream().mapToDouble(promocion -> promocion.descuento(this)).sum();
	}

	public double totalSinDescuento() {
		return productoXCant.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
	}
	
	public  List<ProductoXCant> productosDeProovedor(Proveedor proveedor) {
		 List<ProductoXCant> productos = this.productoXCant.stream().filter(producto -> producto.getProducto().tieneProveedor(proveedor)).collect(Collectors.toList());
		 if(productos.isEmpty()) {
			 return null;
		 }
		 return productos;
	}
	
	public void agregarPromocion(Promocion promo) throws Exception{
		
			this.promociones.add(promo);
		
	}
	
	public void agregarPromociones(Collection<Promocion> promociones) {
		
		Collection<Promocion> promocionesAplicables = promociones.stream().filter(promocion -> promocion.esValidoPara(this)).collect(Collectors.toList());
		
		this.promociones.addAll(promocionesAplicables);
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


	@Override
	public boolean equals(Object obj) {
		OrdenDeCompra otraOrden = (OrdenDeCompra) obj;
		
		return this.id.equals(otraOrden.getId());
	}


	public Collection<ProductoXCant> getProductoXCant() {
		return productoXCant;
	}


	public void setProductoXCant(Collection<ProductoXCant> productoXCant) {
		this.productoXCant = productoXCant;
	}


	public Double getTotalSinDescuento() {
		return totalSinDescuento;
	}


	public void setTotalSinDescuento(Double totalSinDescuento) {
		this.totalSinDescuento = totalSinDescuento;
	}


	public Double getTotalADescontar() {
		return totalADescontar;
	}


	public void setTotalADescontar(Double totalADescontar) {
		this.totalADescontar = totalADescontar;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	
	
	
	
}
