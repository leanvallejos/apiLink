package curso_link_2020.tp_link;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class PromocionControllerComplement {

	@Autowired
	RepoPromocionesSpring repoPromociones;
	
	@RequestMapping(method = RequestMethod.GET, value = "/promociones/activas")
	public @ResponseBody List<Promocion> promocionesActivas() {
		
		List<Promocion> promocionesActivas = repoPromociones.findAllByEstaActivo(true);
			
		return promocionesActivas;
	
	}
}
