package curso_link_2020.tp_link;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("MEMBRESIA")
public class Membresia extends Promocion{
	
	public Membresia() {
		super();
	}

	public Membresia(String nombre, Double porcentaje, boolean estaActivo) {
		super(nombre, porcentaje, estaActivo);
	}

	@Override
	public boolean esValidoPara(OrdenDeCompra ordenDeCompra) {
		return ordenDeCompra.clienteTieneMembresia();
		
	}
	
	

}
