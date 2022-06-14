package curso_link_2020.tp_link;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;


@Component
public class InitData implements CommandLineRunner {

	@Autowired
	private RepoProveedoresSpring repoProveedores;
	
	@Autowired
	private RepoUsuarioSpring repoUsuarios;
	
	@Autowired
	private RepoProductosSpring repoProductos;
	
	@Autowired
	private RepoCarritosSpring repoCarritos;
	
	@Autowired
	private RepoPromocionesSpring repoPromociones;
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Proveedor.class);
		config.exposeIdsFor(Usuario.class);
		config.exposeIdsFor(Producto.class);
		config.exposeIdsFor(OrdenDeCompra.class);
		config.exposeIdsFor(ProductoXCant.class);
		config.exposeIdsFor(Promocion.class);
		config.exposeIdsFor(Cupon.class);
		config.exposeIdsFor(Membresia.class);
		config.exposeIdsFor(PromoMedioPago.class);




	

		
		Proveedor unProveedor = new Proveedor("La Serenisima");
		Proveedor otroProveedor = new Proveedor("Coca cola");
		Usuario lean = new Usuario("lean", "1234", "Leandro", "Vallejos", 12345678, false, TipoUsuario.CLIENTE);
		Producto producto1 = new Producto("Botella Coca-cola", "Botella de 250 ml", 1.0, otroProveedor);
		Producto producto2 = new Producto("Yogur frutilla", "Pote de yogur con sabor a frutilla de 200gr", 1.0, unProveedor);


		
		if(repoProveedores.count() == 0) {
			
			repoProveedores.save(unProveedor);
			repoProveedores.save(otroProveedor);
		}
		
		if(repoUsuarios.count() == 0) {
			repoUsuarios.save(lean);
		}
		
		if(repoProductos.count() == 0) {
			repoProductos.save(producto1);
			repoProductos.save(producto2);
		}
		
		if(repoPromociones.count() == 0) {
			Cupon cupon = new Cupon("Cupon 10% coca-cola", 10.0, true, "1234", otroProveedor, producto1);
			repoPromociones.save((Promocion) cupon);
		}
		/*
		java.util.List<Promocion> listaPromociones = repoPromociones.findAllByEstaActivo(true);
		
		Promocion promocion = listaPromociones.get(0);
		
		System.out.println("La promocion se llama: " + promocion.getNombre());

		
		
		Optional<Carrito> unCarrito = repoCarritos.findById(lean.getCarrito().getId());
		if(!unCarrito.isPresent()) {
			System.out.println("No se encontro el carrito de lean en la base de datos");
		}
		Carrito carritoPosta = unCarrito.get();
		
		Usuario usuarioEncontrado = repoUsuarios.findByCarrito(carritoPosta);
		
		if(usuarioEncontrado == null) {
			System.out.println("No se encontro el usuario del carrito en la base de datos");
		}else {
			System.out.println("El usuario con el carrito de lean es: " + usuarioEncontrado.getNombre());

		}
		*/
		
		

	}

}
