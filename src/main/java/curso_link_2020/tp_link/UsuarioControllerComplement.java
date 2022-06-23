package curso_link_2020.tp_link;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class UsuarioControllerComplement {
	

	@Autowired
	RepoUsuarioSpring repoUsuarios;
	
	@Autowired
	RepoCarritosSpring repoCarritos;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios")
	public @ResponseBody String agregarUsuario(@RequestBody Usuario usuario) {
		
		Carrito carrito = new Carrito();
		
		usuario.setCarrito(carrito);
		repoCarritos.save(carrito);
		repoUsuarios.save(usuario);
		
		return "ok";
		

	}
	

}
