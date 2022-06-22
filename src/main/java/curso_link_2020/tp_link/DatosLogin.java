package curso_link_2020.tp_link;

public class DatosLogin {

	public String usuario;
	public String password;
	public String getUsuario() {
		return usuario;
	}
	
	
	
	public DatosLogin() {
		super();
	}

	

	public DatosLogin(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
