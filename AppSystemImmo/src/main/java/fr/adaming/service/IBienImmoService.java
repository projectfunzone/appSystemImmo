package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmo;

public interface IBienImmoService {
	
	public List<BienImmo> getAllBienImmo();
	
	public BienImmo getBienImmoById(int id);
	
	public BienImmo getBienImmoByType(String typeImmo);

	public BienImmo getBienImmoByCategorie(String categorie);
	
	public BienImmo addBienImmo(BienImmo BI);
	
	public void updateBienImmo(BienImmo BI);
	
	public void deleteBienImmo(BienImmo BI);

}
