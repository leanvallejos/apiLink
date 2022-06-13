package curso_link_2020.tp_link;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "carritos")
public interface RepoCarritosSpring extends PagingAndSortingRepository<Carrito, Integer> {

	Page<Carrito> findAll(Pageable page);

}
