package curso_link_2020.tp_link;

import java.util.ArrayList;
import java.util.Collection;

import domain.ClienteNoTieneMedioDePago;

public class Cliente extends Usuario{

	private String nombre;
	private String apellido;
	private int numDoc;
	private Tarjeta tarjetaDebito;
	private Tarjeta tarjetaCredito;
	private Collection<OrdenDeCompra> ordenesDeCompra;
	private Carrito carrito;
	private boolean tieneMembresia;
	
	
	
	public Cliente(String user, String password, TipoUsuario tipo) {
		super(user, password, tipo);
	}

	

	public Cliente() {
		super();
	}



	public Cliente(String user, String password, TipoUsuario tipo, String nombre, String apellido, int numDoc) {
		super(user, password, tipo);
		this.nombre = nombre;
		this.apellido = apellido;
		this.numDoc = numDoc;
		ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		
	}



	public void adquiereMembresia() {
		this.tieneMembresia = true;
	}
	
	
	public void pagar(double total, MedioPago medioPago) throws Exception {

		Tarjeta tarjeta = medioPago.obtenerTarjeta(this);
		if(tarjeta == null) {
			throw new ClienteNoTieneMedioDePago("El cliente " + this.apellido + this.apellido + " no tiene el medio de pago seleccionado para pagar");
			
		}else {
			tarjeta.pagar(total);
		}
		
	}

	
	
	
	public Carrito getCarrito() {
		return carrito;
	}



	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}



	@Override
	public boolean equals(Object obj) {
		Cliente otroCliente = (Cliente) obj;
		
		return this.getUser().equals(otroCliente.getUser()) ;
	}



	public void agregarOrdenCompra(OrdenDeCompra ordenDeCompra) {
		this.ordenesDeCompra.add(ordenDeCompra);
	}
	
	public Tarjeta getTarjetaDebito() {
		return tarjetaDebito;
	}

	public void setTarjetaDebito(Tarjeta tarjetaDebito) {
		this.tarjetaDebito = tarjetaDebito;
	}

	public Tarjeta getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(Tarjeta tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public boolean getTieneMembresia() {
		return tieneMembresia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}



	public void setTieneMembresia(boolean tieneMembresia) {
		this.tieneMembresia = tieneMembresia;
	}

	
	
	
}
