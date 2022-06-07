package curso_link_2020.tp_link;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String user;
	
	@Column
	private String password;
	
	@Column
	private TipoUsuario tipo;
	
	
	public Usuario() {
		super();
	}


	public Usuario(String user, String password, TipoUsuario tipo) {
		this.user = user;
		this.password =password;
		this.tipo = tipo;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public TipoUsuario getTipo() {
		return tipo;
	}


	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
