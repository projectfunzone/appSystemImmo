package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.ILocationService;

@RestController
@RequestMapping("/location")
public class LocationRest {

	// *****************************************
	@Autowired
	ILocationService locService;

	public void setLocService(ILocationService locService) {
		this.locService = locService;
	}
	// *****************************************

	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	List<Location> getAllLocation() {

		return locService.getAllLocation();
	}

	// ************************************************************************************************
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Location addLocation(@RequestBody Location loc) {
		return locService.addLocation(loc);
	}

	// ************************************************************************************************
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public Location getLocationById(@RequestParam("pId") int id) {
		return locService.getLocation(id);
	}

	// ************************************************************************************************
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public void updateLocation(@RequestBody Location loc) {
		locService.updateLocation(loc);
	}

	// ************************************************************************************************
	@RequestMapping(value = "/delete/{pId}", method = RequestMethod.DELETE)
	public void deleteLocation(@PathVariable("pId") int id) {
		Location loc = new Location();
		loc.setId(id);

		locService.deleteLocation(loc);
	}
	
	
	@RequestMapping(value = "/listeByProprio/{pId}", method = RequestMethod.GET, produces = "application/json")
	List<Location> getAllLocationByProprio(@PathVariable("pId") int id) {
		Proprietaire proprio=new Proprietaire();
		proprio.setId(id);
		
		return locService.getLocationByProprio(proprio);
	}

}
