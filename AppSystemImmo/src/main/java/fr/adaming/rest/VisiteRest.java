package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping("/visites")
public class VisiteRest {

	//transformation de l'association UML en Jave
		@Autowired
		private IVisiteService vService;
		
		
		@RequestMapping(value="/ajoutVisite", method=RequestMethod.POST, produces="application/json", consumes="application/json")
		public Visite ajouterVisite(@RequestBody Visite ac){
			return vService.addVisite(ac);
		}
	
		@RequestMapping(value="/listeVisite", method=RequestMethod.GET, produces="application/json")
		public List<Visite> getAllVisite(){
			return vService.getAllVisite();
		}
	
		public Visite rechercherVisite(){
			return vService.getVisite(id);
		}
		
		
		
		
		
}
