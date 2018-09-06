package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service
public class VisiteServiceImpl implements IVisiteService{
	@Autowired
	IVisiteDao vDao;

	@Override
	public List<Visite> getAllVisite() {
		return vDao.getAll();
	}

	@Override
	public Visite addVisite(Visite ac) {
		return vDao.add(ac);
	}

	@Override
	public Visite getVisite(int id) {
		return vDao.get(id);
	}

	@Override
	public void updateVisite(Visite ac) {
		vDao.update(ac);
		
	}

	@Override
	public void deleteVisite(Visite ac) {
		vDao.delete(ac);
		
	}
	
	}

