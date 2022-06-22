package curso_link_2020.tp_link;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginControllerComplement {

	@Autowired
	RepoUsuarioSpring repoUsuarios;
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login/obtenerUsuario")
	public @ResponseBody Usuario obtenerUsuario(@RequestBody DatosLogin datosLogin) {
	
		
		Usuario usuarioEncontrado = repoUsuarios.findByUserAndPassword(datosLogin.getUsuario(), datosLogin.getPassword());
		if(usuarioEncontrado == null) {
			System.out.println("Usuario no encontrado");

			return null;
		}
		

		return usuarioEncontrado;

	}
}
