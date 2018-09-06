package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.BienImmo;
import fr.adaming.service.IBienImmoService;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
//permet de définir la localisation du fichier de configuration
//application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class BienImmoServiceImplTest {
	
	//******************************************************
//	/**instanciation de service*/
//	@Autowired
//	private IBienImmoService bienImmoService;
	
	//******************************************************	
//	/**cas de test de l'ajout d'une excursion*/
//	
//	@Rollback(true)
//	 @Test
//	 @Transactional
//	public void testaddBienImmo() {
//		BienImmo bienImmoAdd=new BienImmo("la categorie", "le type", 1, "js suis", null, null, 12, null, null);
//		bienImmoService.addBienImmo(bienImmoAdd);
//		assertEquals(1, bienImmoService.getAllBienImmo().size());	
//	}

	//******************************************************
	
//	/**Cas des test GetBienImmo*/
//	@Rollback(true)
//	 @Test
//	 @Transactional
//	public void testGetBienImmoById(){
//		assertEquals(1, bienImmoService.getBienImmoById(1));
//		
//	}
}
