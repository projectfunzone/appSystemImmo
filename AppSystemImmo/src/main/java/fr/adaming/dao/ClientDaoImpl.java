package fr.adaming.dao;

import fr.adaming.model.Client;

public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao {

	// constructeur vide pour spécifier le type de classe au DAO générique
	public ClientDaoImpl() {
		type = Client.class;
	}

}
