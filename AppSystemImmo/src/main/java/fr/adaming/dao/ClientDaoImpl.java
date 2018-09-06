package fr.adaming.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao {

	/**
	 * Constructeur vide pour sp�cifier le type de classe au DAO g�n�rique
	 */
	public ClientDaoImpl() {
		type = Client.class;
	}

	/**
	 * R�cuperer un client dans la DB par son num�ro d'enregistrement
	 * 
	 * @param date
	 * @return Client cibl�
	 */
	@Override
	public Client getClientbyDateNum(Date num) {

		return em.find(Client.class, num);
	}

}
