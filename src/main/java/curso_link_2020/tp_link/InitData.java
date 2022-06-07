package curso_link_2020.tp_link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

	@Autowired
	private RepoProveedoresSpring repoProveedores;
	
	@Override
	public void run(String... args) throws Exception {
		
		if(repoProveedores.count() == 0) {
			Proveedor unProveedor = new Proveedor("La Serenisima");
			Proveedor otroProveedor = new Proveedor("Coca cola");
			repoProveedores.save(unProveedor);
			repoProveedores.save(otroProveedor);
		}
		

	}

}
