package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Achat;
/*
 * Amandine
 * Dao Achat
 */
@Repository
public class AchatDaoImpl extends GenericDaoImpl<Achat> implements IAchatDao{

	public AchatDaoImpl(){
		type=Achat.class;
	}
	
}
