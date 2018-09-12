package fr.adaming.serviceTest;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
// permet de définir la localisation du fichier de configuration
// application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClientServiceImplTest {

	@Autowired
	private IClientService clientService;

	// Cas de test de ajout Client
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddClient() {
		int expected = 1;
		Client clAdd = new Client("JOSSELIN", "Thibault", "0610444267", null, null, null);
		clientService.addClient(clAdd);
		assertEquals(expected, clientService.getAllClients().size());
	}
}
