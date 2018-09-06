package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

public class ProprietaireServiceImpl implements IProprietaireService {

	@Autowired
	private IProprietaireDao proprioDao;
	
	
	@Override
	public List<Proprietaire> getAll() {
		
		return proprioDao.getAll();
	}

	@Override
	public Proprietaire add(Proprietaire proprio) {
		
		return proprioDao.add(proprio);
	}

	@Override
	public Proprietaire get(int id) {
		
		return proprioDao.get(id);
	}

	@Override
	public void update(Proprietaire proprio) {
		proprioDao.update(proprio);
		
	}

	@Override
	public void delete(Proprietaire proprio) {
		proprioDao.delete(proprio);
	}



}
