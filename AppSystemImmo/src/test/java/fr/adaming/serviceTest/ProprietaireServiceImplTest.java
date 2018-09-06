//package fr.adaming.serviceTest;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import fr.adaming.model.Adresse;
//import fr.adaming.model.Proprietaire;
//import fr.adaming.service.IProprietaireService;

////permet de lance
//@RunWith(SpringJUnit4ClassRunner.class)
////permet de définir la localisation du fichier de configuration
////application-context pour lire les annotations
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml"})
//public class ProprietaireServiceImplTest {
//	
//	
//	@Autowired
//	private IProprietaireService proprioService;
//
//
//	@Test
//	@Transactional
//	public void testAddProprio () {
//		Adresse adresse = new Adresse("route de soucelles", "49125", "Briollay", "FRANCE");
//		
//		Proprietaire proprio = new Proprietaire("BOUDET", "Camille", "06----", adresse, "06---");
//		
//		Proprietaire proprioOut=proprioService.add(proprio);
//		
//		assertEquals("BOUDET", proprioOut.getNom());
//	}
//}
