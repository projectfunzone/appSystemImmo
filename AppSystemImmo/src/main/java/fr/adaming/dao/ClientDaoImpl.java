package fr.adaming.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao {

	/**
	 * Constructeur vide pour spécifier le type de classe au DAO générique
	 */
	public ClientDaoImpl() {
		type = Client.class;
	}

	/**
	 * Récuperer un client dans la DB par son numéro d'enregistrement
	 * 
	 * @param date
	 * @return Client ciblé
	 */
	@Override
	public Client getClientbyDateNum(Date num) {

		return em.find(Client.class, num);
	}

}
