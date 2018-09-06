package fr.adaming.dao;

import fr.adaming.model.Location;

public class LocationDaoImpl extends GenericDaoImpl<Location> implements ILocationDao{


	/**
	 * Constructeur vide pour spécifier le type de classe au DAO générique
	 */
	
	public LocationDaoImpl() {
		type=Location.class;
	}
}
