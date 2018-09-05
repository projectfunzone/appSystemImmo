package fr.adaming.dao;

import fr.adaming.model.Client;

public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao {

	// constructeur vide pour sp�cifier le type de classe au DAO g�n�rique
	public ClientDaoImpl() {
		type = Client.class;
	}

}
