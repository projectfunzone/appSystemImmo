package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;
@Repository
public class ProprietaireDaoImpl extends GenericDaoImpl<Proprietaire> implements IProprietaireDao {

	public ProprietaireDaoImpl () {
		type = Proprietaire.class;
	}
}
