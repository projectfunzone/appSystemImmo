package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Achat;
import fr.adaming.model.Proprietaire;

public interface IAchatDao extends IGenericDao<Achat>{

	public List<Achat> getAchatByProprio (Proprietaire proprio);
}
