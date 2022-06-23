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
	RepoProductoXCantSpring repoProductosXCant;
	
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
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/carritos/{carritoId}/eliminarProducto")
	public @ResponseBody String eliminarProducto(@PathVariable("carritoId") Integer carritoId , @RequestBody Integer idProductoXCant) {
		
	
		Optional<ProductoXCant> optionalProductoXCant = repoProductosXCant.findById(idProductoXCant);

		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		
		ProductoXCant productoXCant = optionalProductoXCant.get();
		
		try {
			carrito.eliminarProducto(productoXCant);
			repoProductosXCant.delete(productoXCant);
		}catch (Exception e) {
			return "No se pudo eliminar el producto del carrito";
		}
		
		
		
		return "Se pudo eliminar el producto del carrito";
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/carritos/{carritoId}/productosXCant")
	public @ResponseBody List<ProductoXCant> mostrarProductosXCant(@PathVariable("carritoId") Integer carritoId) {
		

		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		

		
		return (List<ProductoXCant>) carrito.getProductosXCant();
		
	}
	
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/carritos/{carritoId}/generarOrdenDeCompra")
	public @ResponseBody OrdenDeCompra generarOrdenDeCompra(@PathVariable("carritoId") Integer carritoId, @RequestBody Integer numMedioPago) throws Exception{
		
		
		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		
		Usuario usuario = repoUsuarios.findByCarrito(carrito);
		
		Collection<Promocion> promocionesActivas = repoPromociones.findAllByEstaActivo(true);
		
		
		MedioPago medio = this.medioCorrespondiente(numMedioPago);
		
		
		OrdenDeCompra ordenDeCompra = new OrdenDeCompra(LocalDate.now(), carrito.getProductos(), usuario, medio);
		
		ordenDeCompra.agregarPromociones(promocionesActivas);
		ordenDeCompra.setTotalSinDescuento(ordenDeCompra.totalSinDescuento());
		ordenDeCompra.setTotalADescontar(ordenDeCompra.totalADescontar());
		ordenDeCompra.setTotal(ordenDeCompra.total());

		
		return ordenDeCompra;
		
		
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
