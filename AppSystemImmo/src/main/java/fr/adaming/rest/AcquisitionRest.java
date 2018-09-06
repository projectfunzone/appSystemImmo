package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/ajoutAcquisition", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Acquisition ajouterAcquisition(@RequestBody Acquisition ac){
		return acService.addAcquisition(ac);
	}
	
	
	@RequestMapping(value="/listeAcquisition", method=RequestMethod.GET, produces="application/json")
	public List<Acquisition> getAllAcquision(){
		return acService.getAllAcquisition();
	}
	
	
	
}
