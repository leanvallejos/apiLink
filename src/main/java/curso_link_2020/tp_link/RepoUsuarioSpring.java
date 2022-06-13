package curso_link_2020.tp_link;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "usuarios")
public interface RepoUsuarioSpring extends PagingAndSortingRepository<Usuario, Integer> {
	
	Page<Usuario> findAll(Pageable page);
	
	Usuario findByUser(String user);

	@Override
	@RestResource(exported = false)
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}
	
	
}
