package fr.adaming.dao;

import fr.adaming.model.BienImmo;

public interface IBienImmoDao extends IGenericDao<BienImmo>{
	
	public BienImmo getBienImmoByType(String typeBien);
	
	public BienImmo getBienImmoByCategorie(String categorieBien);

}
