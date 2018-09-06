package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;

@Service
@Transactional
public class ConseillerServiceImpl implements IConseillerService {

	@Autowired
	private IConseillerDao conseilDao;
	
	@Override
	public List<Conseiller> getAll() {
		
		return conseilDao.getAll();
	}

	@Override
	public Conseiller add(Conseiller conseil) {
		
		return conseilDao.add(conseil);
	}

	@Override
	public Conseiller get(int id) {
		
		return conseilDao.get(id);
	}

	@Override
	public void update(Conseiller conseil) {
		
		conseilDao.update(conseil);
	}

	@Override
	public void delete(Conseiller conseil) {
		
		conseilDao.delete(conseil.getId());
	}

}
