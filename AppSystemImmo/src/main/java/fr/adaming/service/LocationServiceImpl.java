package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILocationDao;
import fr.adaming.model.Location;

@Service
@Transactional
public class LocationServiceImpl implements ILocationService{
	
	//********************************************
	@Autowired
	ILocationDao locDao;
	//********************************************
	
	@Override
	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		return locDao.getAll();
	}
	//********************************************
	@Override
	public Location addLocation(Location loc) {
		// TODO Auto-generated method stub
		return locDao.add(loc);
	}
	//********************************************
	@Override
	public Location getLocation(int id) {
		// TODO Auto-generated method stub
		return locDao.get(id);
	}
	//********************************************
	@Override
	public void updateLocation(Location loc) {
		// TODO Auto-generated method stub
		locDao.update(loc);
	}
	//********************************************
	@Override
	public void deleteLocation(Location loc) {
		// TODO Auto-generated method stub
		locDao.delete(loc.getId());
	}

}
