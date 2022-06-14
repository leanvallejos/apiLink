package curso_link_2020.tp_link;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
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
	
	@Autowired
	RepoUsuarioSpring repoUsuarios ;
	
	@Autowired
	RepoPromocionesSpring repoPromociones;
	
	
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/carritos/{carritoId}/generarOrdenDeCompra")
	public @ResponseBody OrdenDeCompra generarOrdenDeCompra(@PathVariable("carritoId") Integer carritoId) throws Exception {
		
		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		
		Usuario usuario = repoUsuarios.findByCarrito(carrito);
		
		Collection<Promocion> promocionesActivas = repoPromociones.findAllByEstaActivo(true);
		
		OrdenDeCompra ordenDeCompra = new OrdenDeCompra(LocalDate.now(), carrito.getProductos(), usuario, MedioPago.DEBITO);
		
		ordenDeCompra.agregarPromociones(promocionesActivas);
		ordenDeCompra.setTotalSinDescuento(ordenDeCompra.totalSinDescuento());
		ordenDeCompra.setTotalADescontar(ordenDeCompra.totalADescontar());
		ordenDeCompra.setTotal(ordenDeCompra.total());

		
		return ordenDeCompra;
		
		
	}
	
	
}
