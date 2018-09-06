package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Acquisition;

/*
 * Amandine
 * Dao Acquisition
 */
@Repository
public class AcquisitionDaoImpl extends GenericDaoImpl<Acquisition> implements IAcquisitionDao{

	//Constructeur vide
	public AcquisitionDaoImpl(){
		type=Acquisition.class;
	}
	
	
}
