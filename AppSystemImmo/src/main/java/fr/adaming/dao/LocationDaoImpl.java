package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

@Repository
public class LocationDaoImpl extends GenericDaoImpl<Location> implements ILocationDao {

	@PersistenceContext(unitName = "AppSystemImmo")
	protected EntityManager em;

	/**
	 * Constructeur vide pour spécifier le type de classe au DAO générique
	 */

	public LocationDaoImpl() {
		type = Location.class;
	}

	@Override
	public List<Location> getLocationByProprio(Proprietaire proprio) {

		String req = "FROM Location l WHERE l.proprietaire.id=:pId";

		Query query = em.createQuery(req);

		query.setParameter("pId", proprio.getId());

		return query.getResultList();
	}
}
