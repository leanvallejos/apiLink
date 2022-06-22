package curso_link_2020.tp_link;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class ProductoControllerComplement {
	
	@Autowired
	RepoProductosSpring repoProductos;
	
	@RequestMapping(method = RequestMethod.GET, value = "/productos/habilitados")
	public @ResponseBody Page<Producto> productosHabilitados(Pageable page) {
		
		Page<Producto> productosHabilitados = repoProductos.findAllByHabilitado(true, page);
		
		
		return productosHabilitados;
		

	}
}
