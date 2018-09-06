package fr.adaming.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	IClientDao clDao;

	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
	}

	@Override
	public Client addClient(Client cl) {

		return clDao.add(cl);
	}

	@Override
	public void updateClient(Client cl) {
		clDao.update(cl);
	}

	@Override
	public void deleteClient(Client cl) {
		clDao.delete(cl.getId());

	}

	@Override
	public Client getClient(int id) {
		return clDao.get(id);
	}

	@Override
	public List<Client> getAllClients() {
		return clDao.getAll();
	}

	@Override
	public Client getClientbyDateNum(Date num) {
		return clDao.getClientbyDateNum(num);
	}

}
