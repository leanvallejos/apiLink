package curso_link_2020.tp_link;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class OrdenesDeCompraControllerComplement {

	@Autowired
	RepoOrdenesDeCompraSpring repoOrdenes;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/ordenesDeCompra")
	public @ResponseBody ResponseEntity<OrdenDeCompra> agregarOrden(@RequestBody EntityModel<OrdenDeCompra> orden) {
		
		
		try {
			repoOrdenes.save(orden.getContent());
			
		}catch (Exception e) {
			return null;
		}
		
		Usuario usuario = orden.getContent().getUsuario();
		Carrito carrito = usuario.getCarrito();
		carrito.vaciar();
		
		return ResponseEntity.ok(orden.getContent());
		
	}
	
}
