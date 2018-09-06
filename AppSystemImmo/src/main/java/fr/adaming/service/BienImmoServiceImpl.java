package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IBienImmoDao;
import fr.adaming.model.BienImmo;

@Service
public class BienImmoServiceImpl implements IBienImmoService{
	
	//*************************************************************
	/*Transformation de l'association UML en JAVA*/
	@Autowired
	IBienImmoDao bienImmo;
	//*************************************************************

	@Override
	public List<BienImmo> getAllBienImmo() {
		// TODO Auto-generated method stub
		return bienImmo.getAll();
	}

	@Override
	public BienImmo getBienImmoById(int id) {
		// TODO Auto-generated method stub
		return bienImmo.get(id);
	}

	@Override
	public BienImmo getBienImmoByType(String type) {
		// TODO Auto-generated method stub
		return bienImmo.getBienImmoByType(type);
	}

	@Override
	public BienImmo getBienImmoByCategorie(String categorie) {
		// TODO Auto-generated method stub
		return bienImmo.getBienImmoByCategorie(categorie);
	}

	@Override
	public BienImmo addBienImmo(BienImmo BI) {
		// TODO Auto-generated method stub
		return bienImmo.add(BI);
	}

	@Override
	public void updateBienImmo(BienImmo BI) {
		// TODO Auto-generated method stub
		bienImmo.update(BI);;
	}

	@Override
	public void deleteBienImmo(BienImmo BI) {
		// TODO Auto-generated method stub
		bienImmo.delete(BI);
		
	}

}
