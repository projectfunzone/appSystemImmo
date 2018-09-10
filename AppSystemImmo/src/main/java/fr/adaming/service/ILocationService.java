package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;


public interface ILocationService {
	
	/**
	 * Find all the instance object of the class
	 */
	public List<Location> getAllLocation();

	/** Persist the newInstance object into database */
	public Location addLocation(Location loc);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	public Location getLocation(int id);

	/** Save changes made to a persistent object. */
	public void updateLocation(Location loc);

	/** Remove an object from persistent storage in the database */
	public void deleteLocation(Location loc);
	
	/**Méthode pour récupérer la liste des location par l'id du propriétaire*/
	public List<Location> getLocationByProprio (Proprietaire proprio);

}
