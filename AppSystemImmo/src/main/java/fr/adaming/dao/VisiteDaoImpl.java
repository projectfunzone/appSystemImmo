package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Visite;
@Repository
public class VisiteDaoImpl extends GenericDaoImpl<Visite> implements IVisiteDao{
	//Constructeur vide
	public VisiteDaoImpl(){
		type=Visite.class;
	}
}
