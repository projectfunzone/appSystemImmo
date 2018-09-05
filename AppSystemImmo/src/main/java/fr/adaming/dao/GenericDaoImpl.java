package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDaoImpl<T> implements IGenericDao<T> {

	@PersistenceContext(unitName = "AppSystemImmo")
	private EntityManager em;

	// déclaration de l'entité classe
	protected Class<T> type;

	public void setType(Class<T> type) {
		this.type = type;
	}

	/**
	 * Créer une instance
	 * 
	 * @param T
	 */
	@Override
	public T add(T addInstance) {

		em.persist(addInstance);
		return (T) addInstance;
	}

	/**
	 * Récuperer une instance par son id (PK)
	 * 
	 * @param id
	 */
	@Override
	public T get(int id) {

		return em.find(type, id);
	}

	/**
	 * Mettre à jour une instance
	 * 
	 * @param T
	 */
	@Override
	public void update(T updInstance) {

		em.merge(updInstance);
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
	 * recuperation de l'ensemble des données d'une classe avec Criteria
	 */
	@Override
	public List<T> getAll() {

		// 1. recup du builder pour construire une requete criteria
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		// 2. recup de la requete criteria
		CriteriaQuery query = criteriaBuilder.createQuery();

		// 3. def de la requete racine : l'entity ciblée

		Root from = query.from(type);

		// 4. recup des données
		CriteriaQuery select = query.select(from);

		// 5. recup des données avec l'objet TypedQuery
		TypedQuery typedQuery = em.createQuery(select);

		// retourner la liste des résultas récupérés
		return typedQuery.getResultList();
	}

}