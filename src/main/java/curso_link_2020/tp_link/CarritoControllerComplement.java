package curso_link_2020.tp_link;

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
public class CarritoControllerComplement {

	@Autowired
	RepoCarritosSpring repoCarritos;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/carritos/{carritoId}/agregarProducto")
	public @ResponseBody ResponseEntity<ProductoXCant> agregarProducto(@PathVariable("carritoId") Integer carritoId , @RequestBody EntityModel<ProductoXCant>  productoXCant) {
		

		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		
		try {
			carrito.agregarProducto(productoXCant.getContent());
		}catch (Exception e) {
			return null;
		}
		
		return ResponseEntity.ok(productoXCant.getContent());
		
	}
	
	
}
