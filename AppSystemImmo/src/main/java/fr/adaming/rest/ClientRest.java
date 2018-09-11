package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRest {

	// transformation del 'association uml java
	@Autowired
	private IClientService clientService;

	
	/**
	 * Recupérer la liste des Clients enregistrés
	 * 
	 * @return la liste des Clients
	 */
	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	
	/**
	 * Recupérer le client par son id
	 * 
	 * @return le client correspondant à l'id
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public Client getClientbyID(@RequestParam("pId") int id) {
		return clientService.getClient(id);
	}

	/**
	 * Ajouter le client passé en paramètre
	 * 
	 * @return le client ajouté
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Client addClient(@RequestBody Client cl) {
		clientService.sendMail(cl);
		return clientService.addClient(cl);
	}

	/**
	 * Modifier le client passé en paramètre
	 * 
	 * @return pas de retour
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateClient(@RequestBody Client cl) {
		clientService.updateClient(cl);
	}

	/**
	 * Supprimer le client ciblé
	 * 
	 * @return pas de retour
	 */
	@RequestMapping(value = "/delete/{pId}", method = RequestMethod.DELETE)
	public void deleteEtudiant(@PathVariable("pId") int id) {
		Client clIn = new Client();
		clIn.setId(id);
		clientService.deleteClient(clIn);
	}

}
