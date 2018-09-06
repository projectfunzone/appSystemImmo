package fr.adaming.service;

import java.util.Date;
import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	// methode du CRUD
	public Client addClient(Client cl);

	public void updateClient(Client cl);

	public void deleteClient(Client cl);

	public Client getClient(int id);

	// accéder à la liste d'enregistrement
	public List<Client> getAllClients();

	// methode metier
	public Client getClientbyDateNum(Date num);
}
