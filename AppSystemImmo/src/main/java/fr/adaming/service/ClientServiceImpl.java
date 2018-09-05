package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	IClientDao clDao;

}
