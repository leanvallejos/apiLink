package curso_link_2020.tp_link;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import domain.ApiConvertidor;
import domain.ConvertidorDolarPesos;

@Entity
public class Producto {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private Double precioDolar;

	@ManyToOne
	private Proveedor proveedor;
	
	@Column(length = 1000)
	private String urlImagen;
	
	@Column
	private boolean habilitado;
	
	//@Transient
	//private ConvertidorDolarPesos convertidor;
	
	
	
	
	
	public Producto() {
		super();
	}

	public Producto(String nombre, String descripcion, Double precioDolar, Proveedor proveedor, String urlImagen) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioDolar = precioDolar;
		this.proveedor = proveedor;
		this.urlImagen = urlImagen;
		this.habilitado = true;
		
	}
	
	
	

	@Override
	public boolean equals(Object obj) {
		Producto otroProducto = (Producto) obj;
		
		return this.tieneNombre(otroProducto.getNombre()) && this.tieneProveedor(otroProducto.getProveedor());
	}

	
	public boolean tieneProveedor(Proveedor proveedor2) {
		
		return this.proveedor.equals(proveedor2);
	}

	public boolean tieneNombre(String nombre2) {
		
		return this.getNombre().equals(nombre2);
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	
	
	
}
