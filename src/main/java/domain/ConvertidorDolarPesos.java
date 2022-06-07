package domain;

public abstract class ConvertidorDolarPesos {
	
	String url;

	
	public ConvertidorDolarPesos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ConvertidorDolarPesos(String url) {
		super();
		this.url = url;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public abstract Double convertirAPesos(Double dolares);
	public abstract Double convertirADolares(Double pesos);
}
