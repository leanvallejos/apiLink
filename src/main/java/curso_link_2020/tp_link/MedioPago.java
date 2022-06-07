package curso_link_2020.tp_link;

public enum MedioPago {
	DEBITO{
		public Tarjeta obtenerTarjeta(Cliente cliente) {
			return cliente.getTarjetaDebito();
		}
		
	}
	,
	CREDITO{
		public Tarjeta obtenerTarjeta(Cliente cliente) {
			return cliente.getTarjetaDebito();
		}
		
		public double minimoPermitido() {
			return 100;
		}
	};

	public Tarjeta obtenerTarjeta(Cliente cliente) {
		return null;
	}

	public double minimoPermitido() {
		return 0;
	}

	
}
