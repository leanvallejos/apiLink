package curso_link_2020.tp_link;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "proveedores")
public interface RepoProveedoresSpring extends PagingAndSortingRepository<Proveedor, Integer> {

	Page<Proveedor> findAll(Pageable page);
	
	Proveedor findByNombre(String nombre);
	
}
