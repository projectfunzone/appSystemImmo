package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Location;
@Repository
public class LocationDaoImpl extends GenericDaoImpl<Location> implements ILocationDao{


	/**
	 * Constructeur vide pour sp�cifier le type de classe au DAO g�n�rique
	 */
	
	public LocationDaoImpl() {
		type=Location.class;
	}
}
