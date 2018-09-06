package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Achat;
import fr.adaming.service.IAchatService;

@RestController
@RequestMapping("/achat")
public class AchatRest {

	//transformation de l'association UML en Jave
	@Autowired
	private IAchatService aService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Achat ajouterAchat(@RequestBody Achat ac){
		return aService.addAchat(ac);
	}
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Achat> getAllAchat(){
		return aService.getAllAchat();
	}
	@RequestMapping(value="/get", method=RequestMethod.GET, produces="application/json")
	public Achat rechercheAchat (@RequestParam(value="pId") int id){
		return aService.getAchat(id);
	}
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public void modifierAchat(@RequestBody Achat ac){
		aService.updateAchat(ac);
	}
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE, produces="application/json", consumes="application/json")
	public void supprimerAchat(@PathVariable(value="pId") int id){
		Achat aOut=new Achat();
		aOut.setId(id);
		aService.deleteAchat(id);
	}
	
	
	
}
