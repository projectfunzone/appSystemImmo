package fr.adaming.dao;

import fr.adaming.model.Location;

public class LocationDaoImpl extends GenericDaoImpl<Location> implements ILocationDao{


	/**
	 * Constructeur vide pour sp�cifier le type de classe au DAO g�n�rique
	 */
	
	public LocationDaoImpl() {
		type=Location.class;
	}
}
