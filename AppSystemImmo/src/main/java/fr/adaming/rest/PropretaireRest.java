package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Proprietaire> getAll () {
		
		return proprioService.getAll();
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET, produces="application/json")
	public Proprietaire getOne (@RequestParam("pId") int id) {
		
		return proprioService.get(id);
	}
	
	@RequestMapping(value="/add",  method=RequestMethod.POST, produces = "application/json", consumes="application/json" )
	public Proprietaire add (@RequestBody Proprietaire proprio){
		
		return proprioService.add(proprio);
	}
	
	@RequestMapping(value="/update",  method=RequestMethod.PUT, produces = "application/json", consumes="application/json" )
	public void update (@RequestBody Proprietaire proprio) {
		
		proprioService.update(proprio);
	}
	
	@RequestMapping(value="/delete/{pId}",  method=RequestMethod.DELETE)
	public void delete (@PathVariable("pId") int id) {
		Proprietaire proprio=new Proprietaire();
		proprio.setId(id);
		
		proprioService.delete(proprio);
	}
	
	
}
