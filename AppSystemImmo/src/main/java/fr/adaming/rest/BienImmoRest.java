package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmo;
import fr.adaming.service.IBienImmoService;

@RestController
@RequestMapping("/bienimmo")
public class BienImmoRest {
	
	// ************************************************************************************************
	
	@Autowired
	IBienImmoService bienService;
	 //************************************************************************************************
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<BienImmo> getAll(){
		return bienService.getAllBienImmo();
	}
	
	 //************************************************************************************************
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public BienImmo addBienImmo(@RequestBody BienImmo BI){
		return bienService.addBienImmo(BI);
	}
	
	
	
}
