package curso_link_2020.tp_link;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "ordenesDeCompra")
@CrossOrigin("http://localhost:4200")
public interface RepoOrdenesDeCompraSpring extends PagingAndSortingRepository<OrdenDeCompra, Integer> {

}
