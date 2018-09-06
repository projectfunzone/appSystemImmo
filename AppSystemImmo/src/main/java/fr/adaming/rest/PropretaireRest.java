package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
@RequestMapping("/proprietaire")
public class PropretaireRest {

	@Autowired
	private IProprietaireService proprioService;

	public void setProprioService(IProprietaireService proprioService) {
		this.proprioService = proprioService;
	}
	
	
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	List<Proprietaire> getAll () {
		
		return proprioService.getAll();
	}
	
	
	
	
}
