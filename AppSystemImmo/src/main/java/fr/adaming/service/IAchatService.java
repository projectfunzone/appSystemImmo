package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Achat;


public interface IAchatService {

	public List<Achat> getAllAchat();

	public Achat addAchat(Achat ac);

	public Achat getAchat(int id);

	public void updateAchat(Achat ac);

	public void deleteAchat(int id);
	

	
	
}
