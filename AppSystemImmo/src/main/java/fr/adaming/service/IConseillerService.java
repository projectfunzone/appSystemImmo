package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerService {

	/**
	 * Find all the instance object of the class
	 */
	public List<Conseiller> getAll();

	/** Persist the newInstance object into database */
	public Conseiller add(Conseiller conseil);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	public Conseiller get(int id);

	/** Save changes made to a persistent object. */
	public void update(Conseiller conseil);

	/** Remove an object from persistent storage in the database */
	public void delete(Conseiller conseil);
}
