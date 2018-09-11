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

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;
@Service
@Transactional
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
		proprioDao.delete(proprio.getId());
	}

	@Override
	public void sendMail(Proprietaire proprio) {
		// mon compte gmail (pour recevoir les mail avec pdf)
		
		final String username="projectfunzone44@gmail.com";
		final String password="funzone44";
		//Les proprietés du mail
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		// La recuperation d'une session
		
		Session session=Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		try{
			//La creation de l'objet Message par MimeMessage
			Message message=new MimeMessage(session);
			//Passage du message au username
			message.setFrom(new InternetAddress(username));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(proprio.getMail()));
			
			// Set Subject: header du message
			message.setSubject("Mail inscription");
			
			ByteArrayOutputStream outputStream=null;
			
			//Partie 1: Le text
			MimeBodyPart mbp1=new MimeBodyPart();
			mbp1.setText("Cher(e) Propritaire, " +" M.(me) " + proprio.getNom() + proprio.getPrenom() + "\n\n Merci de votre confiance!"
					+ "\n Votre inscription  s'est bien effectuée sur notre site AppSystemImmo"
					+ "\n Votre identifiant est: "+ proprio.getMail()
					+ "\n Votre Tel privé est: "+ proprio.getTelPrive()
					+ "\n Votre Tel Pro est: "+ proprio.getTelPro()
					+ "\n Votre liste de bien à vendre est: "+ proprio.getListeBienAchat()
					+ "\n Votre liste de bien à louer est: "+ proprio.getListeBienLocation()
					+ "\n\n\n L'equipe AppSystemImmo vous souhaite la bienvenue sur notre site!");
			
			//Ecrire le pdf dans outputStream
			outputStream =new ByteArrayOutputStream();
			
			//On regroupe les deux dans le message maitenant
			MimeMultipart mp=new MimeMultipart();
			mp.addBodyPart(mbp1);
			//mp.addBodyPart(pdfbp);
			message.setContent(mp);
			
			//On en voie le message
			Transport.send(message);
			//Verification de la reussite de l'envoie du mail
			System.out.println("DSD envoi du mail reussi ");
						
		}catch(Exception e){
			throw new RuntimeException(e);
		}		

}
		
	



}
