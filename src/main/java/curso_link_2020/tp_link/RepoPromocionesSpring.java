package curso_link_2020.tp_link;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "promociones")
public interface RepoPromocionesSpring extends PagingAndSortingRepository<Promocion, Integer> {

	Collection<Promocion> findAllByEstaActivo(boolean estaActivo);
	
//	Page<Promocion> findAll(Pageable page);

//	Page<Promocion> findAllBytipo(Pageable page);
	
	
}
