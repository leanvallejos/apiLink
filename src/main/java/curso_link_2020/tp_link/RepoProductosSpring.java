package curso_link_2020.tp_link;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "productos")
@CrossOrigin("http://localhost:4200")
public interface RepoProductosSpring extends PagingAndSortingRepository<Producto, Integer> {

	List<Producto> findAll();
	
	List<Producto> findAllByNombre(String nombre);
	
	List<Producto> findAllByHabilitado(boolean habilitado);
	
	Producto findByNombre(String nombre);
	
}
