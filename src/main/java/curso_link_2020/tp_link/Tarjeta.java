package curso_link_2020.tp_link;

import domain.TarjetaNoTieneSuficienteSaldo;

public class Tarjeta {
	
	private String nombreTarjeta;
	private Double saldo;

	public void pagar(double total) throws TarjetaNoTieneSuficienteSaldo {
		if(this.saldo < total) {
			throw new TarjetaNoTieneSuficienteSaldo("La tarjeta " + this.nombreTarjeta + " no tiene suficiente saldo para pagar " + String.valueOf(total));
		}else {
			saldo -= total;
		}
	}

}
