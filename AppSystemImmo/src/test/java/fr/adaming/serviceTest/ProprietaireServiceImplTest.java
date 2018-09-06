package fr.adaming.serviceTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.service.IProprietaireService;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
//permet de définir la localisation du fichier de configuration
//application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })

public class ProprietaireServiceImplTest {
	
	
	@Autowired
	private IProprietaireService proprioService;
	
	public void 

}
