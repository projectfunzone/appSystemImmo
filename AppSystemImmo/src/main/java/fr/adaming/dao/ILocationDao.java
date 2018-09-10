package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

public interface ILocationDao extends IGenericDao<Location>{

	public List<Location> getLocationByProprio (Proprietaire proprio);
}
