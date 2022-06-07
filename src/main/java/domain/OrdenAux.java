package domain;

import java.time.LocalDate;
import java.util.Collection;

import curso_link_2020.tp_link.MedioPago;

public class OrdenAux {
	
	private Integer id;
	private LocalDate fecha;
	private String nombreUsuario;
	private MedioPago medioPago;
	
	public OrdenAux(Integer id, LocalDate fecha, String nombreUsuario, MedioPago medioPago) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.nombreUsuario = nombreUsuario;
		this.medioPago = medioPago;
	}

	public OrdenAux() {
		super();
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


	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}
	
	
	
}
