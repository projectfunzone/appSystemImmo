package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping("/visite")
public class VisiteRest {

	//transformation de l'association UML en Jave
		@Autowired
		private IVisiteService vService;
		
		
		@RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json", consumes="application/json")
		public Visite ajouterVisite(@RequestBody Visite ac){
			return vService.addVisite(ac);
		}
	
		@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
		public List<Visite> getAllVisite(){
			return vService.getAllVisite();
		}
		@RequestMapping(value="/get", method=RequestMethod.GET, produces="application/json")
		public Visite rechercherVisite(@RequestParam(value="pId") int id){
			return vService.getVisite(id);
		}
		
		@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
		public void modifierVisite(@RequestBody Visite ac){
			vService.updateVisite(ac);
		}
		@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE, produces="application/json", consumes="application/json")
		public void supprimerVisite(@PathVariable(value="pId") int id){
			Visite sOut= new Visite();
			sOut.setId(id);
			vService.deleteVisite(id);
		}
		
		
}
