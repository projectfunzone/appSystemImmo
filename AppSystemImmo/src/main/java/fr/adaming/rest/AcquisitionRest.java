package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Acquisition;
import fr.adaming.service.IAcquisitionService;

@RestController
@RequestMapping("/acquisition")
public class AcquisitionRest {

	//transformation de l'association UML en Jave
	@Autowired
	private IAcquisitionService acService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Acquisition ajouterAcquisition(@RequestBody Acquisition ac){
		return acService.addAcquisition(ac);
	}
	
	
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Acquisition> getAllAcquision(){
		return acService.getAllAcquisition();
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET, produces="application/json")
	public Acquisition rechercherAcquisition(@RequestParam(value="pId") int id){
		return acService.getAcquisition(id);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public void modifierAcquisition (@RequestBody Acquisition ac){
		acService.updateAcquisition(ac);
	}
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE, produces="application/json", consumes="application/json")
	public void supprimerAcquisition(@PathVariable(value="pId") int id){
		Acquisition acOut=new Acquisition();
		acOut.setId(id);
		acService.deleteAcquisition(id);
	}
	
	
	
	
}
