package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T, PK extends Serializable> implements IGenericDao<T, PK> {

	@PersistenceContext(unitName = "AppSystemImmo")
	private EntityManager em;

	// d�claration de l'entit� classe
	private Class<T> type;

	/**
	 * Cr�er une instance
	 * 
	 * @param T
	 */
	@Override
	public T create(T addInstance) {
		em.persist(addInstance);
		return (T) addInstance;
	}

	/**
	 * R�cuperer une instance par son id (PK)
	 * 
	 * @param id
	 */
	@Override
	public T read(Serializable id) {
		return em.find(type, id);
	}

	/**
	 * Mettre � jour une instance
	 * 
	 * @param T
	 */
	@Override
	public int update(T updInstance) {
		return (int) em.merge(updInstance);
	}

	/**
	 * Supprimer une instance
	 * 
	 * @param T
	 */
	@Override
	public void delete(T delInstance) {
		em.remove(delInstance);
	}

	/**
	 * recuperation de l'ensemble des donn�es d'une classe avec Criteria
	 */
	@Override
	public List<T> ListeAll() {

		// 1. recup du builder pour construire une requete criteria
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		// 2. recup de la requete criteria
		CriteriaQuery query = criteriaBuilder.createQuery();

		// 3. def de la requete racine : l'entity cibl�e

		Root from = query.from(type);

		// 4. recup des donn�es
		CriteriaQuery select = query.select(from);

		// 5. recup des donn�es avec l'objet TypedQuery
		TypedQuery typedQuery = em.createQuery(select);

		// retourner la liste des r�sultas r�cup�r�s
		return typedQuery.getResultList();
	}

}