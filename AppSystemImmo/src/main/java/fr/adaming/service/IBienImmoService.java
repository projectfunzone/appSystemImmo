package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmo;

public interface IBienImmoService {
	
	public List<BienImmo> getAllBienImmo();
	
	public BienImmo getBienImmoById(int id);
	
	public BienImmo getBienImmoById(String type);
	
	public BienImmo getBienImmoByCategorie(String categorie);
	
	public BienImmo addBienImmo(BienImmo BI);
	
	public BienImmo updateBienImmo(BienImmo BI);
	
	public void deleteBienImmo(BienImmo BI);

}
