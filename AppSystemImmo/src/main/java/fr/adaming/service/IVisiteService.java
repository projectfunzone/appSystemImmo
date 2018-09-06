package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;



public interface IVisiteService {

	public List<Visite> getAllVisite();

	public Visite addVisite(Visite ac);

	public Visite getVisite(int id);

	public void updateVisite(Visite ac);

	public void deleteVisite(Visite ac);
	
	
}
