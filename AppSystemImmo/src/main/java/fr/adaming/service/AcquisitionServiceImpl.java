package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.AcquisitionDaoImpl;

import fr.adaming.model.Acquisition;

@Service
@Transactional
public class AcquisitionServiceImpl implements IAcquisitionService{
	@Autowired
	AcquisitionDaoImpl acDao;

	@Override
	public List<Acquisition> getAllAcquisition() {
		return acDao.getAll();
	}

	@Override
	public Acquisition addAcquisition(Acquisition ac) {
		return acDao.add(ac);
	}

	@Override
	public Acquisition getAcquisition(int id) {
		return acDao.get(id);
	}

	@Override
	public void updateAcquisition(Acquisition ac) {
		acDao.update(ac);
	}

	@Override
	public void deleteAcquisition(int id) {
		acDao.delete(id);
		
	}

	
	
}
