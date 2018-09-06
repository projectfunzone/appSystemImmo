package fr.adaming.dao;

import java.util.Date;

import fr.adaming.model.Client;

public interface IClientDao extends IGenericDao<Client> {

	/**
	 * Rechercher un client par son numero d'enregistrement � date fixe
	 * @param numero en fonction de la date d'enregistrement
	 * @return le client cibl�
	 */
	public Client getClientbyDateNum(Date num);
}
