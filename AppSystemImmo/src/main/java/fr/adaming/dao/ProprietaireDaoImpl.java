package fr.adaming.dao;

import fr.adaming.model.Proprietaire;

public class ProprietaireDaoImpl extends GenericDaoImpl<Proprietaire> implements IProprietaireDao {

	public ProprietaireDaoImpl () {
		type = Proprietaire.class;
	}
}
