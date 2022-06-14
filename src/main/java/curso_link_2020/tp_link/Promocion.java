package curso_link_2020.tp_link;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "TIPO")
public class Promocion {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private Double porcentaje;
	
	@Column
	private boolean estaActivo;


	
	public Promocion() {
		super();
	}


	public Promocion(String nombre, Double porcentaje, boolean estaActivo) {
		super();
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.estaActivo = estaActivo;
	}


	public double descuento(OrdenDeCompra orden) {
		if(this.esValidoPara(orden)) {
			
			double totalADescontar = this.totalADescontar(orden);
			return totalADescontar*(porcentaje/100);
		}
		return 0;
	}


	public Double totalADescontar(OrdenDeCompra orden) {
		
		return orden.totalSinDescuento();
	}


	public boolean esValidoPara(OrdenDeCompra ordenDeCompra) {
		
		return true;
	}


	public Double getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}


	public boolean isEstaActivo() {
		return estaActivo;
	}


	public void setEstaActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}


	public boolean tieneNombre(String nombre2) {
		return this.nombre.equals(nombre2);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public boolean equals(Object obj) {
		
		Promocion promo = (Promocion) obj;
		
		return this.tieneNombre(promo.getNombre());
	}


	public boolean tieneCodigo(String codigo) {
		return false;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
