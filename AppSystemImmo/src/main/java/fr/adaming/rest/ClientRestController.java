package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	// transformation del 'association uml java
	@Autowired
	private IClientService clientService;

	
	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

}
