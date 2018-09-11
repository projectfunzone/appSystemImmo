package fr.adaming.service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAchatDao;
import fr.adaming.model.Achat;
import fr.adaming.model.Proprietaire;

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

	@Override
	public List<Achat> getAchatByProprio(Proprietaire proprio) {
		// TODO Auto-generated method stub
		return aDao.getAchatByProprio(proprio);
	}
}
