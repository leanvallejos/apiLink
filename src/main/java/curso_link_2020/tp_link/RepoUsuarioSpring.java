package curso_link_2020.tp_link;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "usuarios")
public interface RepoUsuarioSpring extends PagingAndSortingRepository<Usuario, Integer> {
	
	List<Usuario> findAll();
	
	Usuario findByUser(String user);
	
	Usuario findByUserAndPassword(String user, String password);
	
	Usuario findByCarrito(Carrito carrito);
	
}
