package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, PK extends Serializable> {

	/**
	 * Find all the instance object of the class
	 */
	public List<T> ListeAll();

	/** Persist the newInstance object into database */
	public T create(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	public T read(PK id);

	/** Save changes made to a persistent object. */
	public void update(T transientObject);

	/** Remove an object from persistent storage in the database */
	public void delete(T persistentObject);
}
