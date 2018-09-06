package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {

	/**
	 * Find all the instance object of the class
	 */
	public List<Proprietaire> getAll();

	/** Persist the newInstance object into database */
	public Proprietaire add(Proprietaire proprio);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	public Proprietaire get(int id);

	/** Save changes made to a persistent object. */
	public void update(Proprietaire proprio);

	/** Remove an object from persistent storage in the database */
	public void delete(Proprietaire proprio);
}
