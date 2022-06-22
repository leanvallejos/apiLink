package curso_link_2020.tp_link;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "promosCupon")
public interface RepoCuponesSpring extends PagingAndSortingRepository<Cupon, Integer> {

	Cupon findByCodigo(String codigo);
}
