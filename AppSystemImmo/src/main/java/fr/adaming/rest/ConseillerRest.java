package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Conseiller;
import fr.adaming.service.IConseillerService;

@RestController
@RequestMapping("/conseiller")
public class ConseillerRest {
	
	@Autowired
	private IConseillerService conseilService;

	public void setConseilService(IConseillerService conseilService) {
		this.conseilService = conseilService;
	}
	
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Conseiller> getAll () {
		
		return conseilService.getAll();
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET, produces="application/json")
	public Conseiller getOne (@RequestParam("pId") int id) {
		
		return conseilService.get(id);
	}
	
	@RequestMapping(value="/add",  method=RequestMethod.POST, produces = "application/json", consumes="application/json" )
	public Conseiller add (@RequestBody Conseiller conseil){
		
		return conseilService.add(conseil);
	}
	
	@RequestMapping(value="/update",  method=RequestMethod.PUT, produces = "application/json", consumes="application/json" )
	public void update (@RequestBody Conseiller conseil) {
		
		conseilService.update(conseil);
	}
	
	@RequestMapping(value="/delete/{pId}",  method=RequestMethod.DELETE)
	public void deleteCarg (@PathVariable("pId") int id) {
		Conseiller conseil=new Conseiller();
		conseil.setId(id);
		
		conseilService.delete(conseil);
	}

}
