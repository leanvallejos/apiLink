package curso_link_2020.tp_link;

public enum MedioPago {
	DEBITO,
	CREDITO;

	

	public double minimoPermitido() {
		return 0;
	}
	


	public MedioPago medioCorrespondiente(Integer num) {
		switch(num) {
		
		case 1:
			return MedioPago.DEBITO;
		
		case 2:
			return MedioPago.CREDITO;
		}
		
		return null;
	}
}
