package fr.adaming.dao;

import java.util.List;

public interface IGenericDao<T> {

	/**
	 * Find all the instance object of the class
	 */
	public List<T> getAll();

	/** Persist the newInstance object into database */
	public T add(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	public T get(int id);

	/** Save changes made to a persistent object. */
	public void update(T transientObject);

	/** Remove an object from persistent storage in the database */
	public void delete(T persistentObject);

	// setters
	public void setType(Class<T> type);
}
