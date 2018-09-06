package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Location;
@Repository
public class LocationDaoImpl extends GenericDaoImpl<Location> implements ILocationDao{


	/**
	 * Constructeur vide pour spécifier le type de classe au DAO générique
	 */
	
	public LocationDaoImpl() {
		type=Location.class;
	}
}
