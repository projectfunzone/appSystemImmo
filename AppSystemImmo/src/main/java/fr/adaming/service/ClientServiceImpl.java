package fr.adaming.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Client;

@Service
public class ClientServiceImpl implements IClientService  {

	IClientDao clDao;

	@Autowired
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
		clDao.setType(Client.class);
	}

	
	
	
}
