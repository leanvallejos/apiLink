package curso_link_2020.tp_link;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("MEDIOPAGO")
public class PromoMedioPago extends Promocion{

	@Enumerated(EnumType.STRING)
	private MedioPago medioPago;
	
	

	public PromoMedioPago() {
		super();
	}



	public PromoMedioPago(String nombre, Double porcentaje, boolean estaActivo, MedioPago medioPago) {
		super(nombre, porcentaje, estaActivo);
		this.medioPago = medioPago;

	}



	@Override
	public boolean esValidoPara(OrdenDeCompra ordenDeCompra) {
		
		return ordenDeCompra.totalSinDescuento() > medioPago.minimoPermitido();
	}



	public MedioPago getMedioPago() {
		return medioPago;
	}



	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}
	
	

}
