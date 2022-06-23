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


		Proveedor unProveedor = new Proveedor("Arcor");
		Proveedor otroProveedor = new Proveedor("Coca cola");
		Carrito carritoLean = new Carrito();
		Carrito carritoPepe = new Carrito();
		Usuario lean = new Usuario("lean", "1234", "Leandro", "Vallejos", 12345678, true, TipoUsuario.CLIENTE);
		lean.setCarrito(carritoLean);
		Usuario pepe = new Usuario("pepe", "1234", "Pepe", "Gonzales", 12345678, false, TipoUsuario.VENDEDOR);
		pepe.setCarrito(carritoPepe);
		Producto producto1 = new Producto("Botella Coca-cola", "Botella de 250 ml", 1.0, otroProveedor, "https://th.bing.com/th/id/R.1f5e065568fadec8772afc7f5c758ac5?rik=HtwSkwwCezoG0w&riu=http%3a%2f%2fwww.ovmpaper.ro%2fuserfiles%2fb9ac6e60-07a4-4e60-bbf9-a9c87fc63dfa%2fproducts%2f4339136_big.jpg&ehk=T8POFiBIMoCyJYc28yI6TdkIpdQ3iYwShILJozWbkrA%3d&risl=&pid=ImgRaw&r=0" );
		Producto producto2 = new Producto("Barra de chocolate", "Barra de chocolate re rico re copado perfecto para ese antojo que tenes ahora mismo fua unas ganas de un chocolate", 1.0, unProveedor, "https://www.drogariaminasbrasil.com.br/media/product/d70/chocolate-em-barra-arcor-ao-leite-100g-dd2.jpg");


		
		if(repoProveedores.count() == 0) {
			
			repoProveedores.save(unProveedor);
			repoProveedores.save(otroProveedor);
		}
		/*
		if(repoUsuarios.count() == 0) {
			repoCarritos.save(carritoLean);
			repoCarritos.save(carritoPepe);
			repoUsuarios.save(lean);
			repoUsuarios.save(pepe);

		}
		
		*/
		
		if(repoProductos.count() == 0) {
			repoProductos.save(producto1);
			repoProductos.save(producto2);
			Cupon cupon = new Cupon("Cupon 10% coca-cola", 10.0, true, "1234", otroProveedor, producto1);
			repoPromociones.save((Promocion) cupon);
		}
		
		
		
		
		

	}

}
