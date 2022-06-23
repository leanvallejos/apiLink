package curso_link_2020.tp_link;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "usuaries")
public interface Repo2Usuarios extends PagingAndSortingRepository<Usuario, Integer> {

}
