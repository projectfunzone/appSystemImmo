package fr.adaming.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Achat;
import fr.adaming.model.Proprietaire;
/*
 * Amandine
 * Dao Achat
 */
@Repository
public class AchatDaoImpl extends GenericDaoImpl<Achat> implements IAchatDao{

	public AchatDaoImpl(){
		type=Achat.class;
	}

	@Override
	public List<Achat> getAchatByProprio(Proprietaire proprio) {
		String req = "FROM Achat a WHERE a.proprietaire.id=:pId";

		Query query = em.createQuery(req);

		query.setParameter("pId", proprio.getId());

		return query.getResultList();
	}
	
}
