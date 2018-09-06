package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAchatDao;
import fr.adaming.model.Achat;

@Service
@Transactional
public class AchatServiceImpl implements IAchatService{

	@Autowired
	IAchatDao aDao;
	
	
	@Override
	public List<Achat> getAllAchat() {
		return aDao.getAll();
	}

	@Override
	public Achat addAchat(Achat ac) {
		return aDao.add(ac);
	}

	@Override
	public Achat getAchat(int id) {
		return aDao.get(id);
	}

	@Override
	public void updateAchat(Achat ac) {
		aDao.update(ac);
		
	}

	@Override
	public void deleteAchat(int id) {
		aDao.delete(id);
		
	}

}
