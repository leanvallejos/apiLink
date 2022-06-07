package curso_link_2020.tp_link;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productos")
public interface RepoProductosSpring extends PagingAndSortingRepository<Producto, Integer> {

	List<Producto> findAll();
	
	List<Producto> findAllByNombre(String nombre);
	
	Producto findByNombre(String nombre);
	
}
