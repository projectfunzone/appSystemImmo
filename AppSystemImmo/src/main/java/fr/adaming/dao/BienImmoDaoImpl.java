package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmo;

@Repository
public class BienImmoDaoImpl extends GenericDaoImpl<BienImmo> implements IBienImmoDao{

	@Override
	public BienImmo getBienImmoByType(String typeBien) {
		// 
		return null;
	}

	@Override
	public BienImmo getBienImmoByCategorie(String categorieBien) {
		// 
		return null;
	}

}
