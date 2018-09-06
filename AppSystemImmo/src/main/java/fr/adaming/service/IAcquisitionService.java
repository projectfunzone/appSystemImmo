package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Acquisition;

public interface IAcquisitionService {

	public List<Acquisition> getAllAcquisition();

	public Acquisition addAcquisition(Acquisition ac);

	public Acquisition getAcquisition(int id);

	public void updateAcquisition(Acquisition ac);

	public void deleteAcquisition(int id);
	
	
	
}
