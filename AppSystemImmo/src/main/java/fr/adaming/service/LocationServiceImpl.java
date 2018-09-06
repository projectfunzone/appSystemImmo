package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Location;

public class LocationServiceImpl implements ILocationService{
	
	//********************************************
	@Autowired
	ILocationService locService;
	//********************************************
	
	@Override
	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		return locService.getAllLocation();
	}
	//********************************************
	@Override
	public Location addLocation(Location loc) {
		// TODO Auto-generated method stub
		return locService.addLocation(loc);
	}
	//********************************************
	@Override
	public Location getLocation(int id) {
		// TODO Auto-generated method stub
		return locService.getLocation(id);
	}
	//********************************************
	@Override
	public void updateLocation(Location loc) {
		// TODO Auto-generated method stub
		locService.updateLocation(loc);
	}
	//********************************************
	@Override
	public void deleteLocation(Location loc) {
		// TODO Auto-generated method stub
		locService.deleteLocation(loc);
	}

}
